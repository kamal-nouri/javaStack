package com.swift.abdusalam.events.validator;

import com.swift.abdusalam.events.models.User;
import com.swift.abdusalam.events.repositories.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    private final UserRepository userRepository;

    public UserValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 1
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    // 2
    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        User userEmail = userRepository.findByEmail(user.getEmail());

        if (!user.getPasswordConfirmation().equals(user.getPassword())) {
            // 3
            errors.rejectValue("passwordConfirmation", "Match");
        }
        if(userEmail!=null){
            errors.rejectValue("email", "Exist");
        }
    }
}
