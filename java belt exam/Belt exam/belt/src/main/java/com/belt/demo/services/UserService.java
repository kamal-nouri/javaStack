package com.belt.demo.services;

import com.belt.demo.models.Rating;
import com.belt.demo.models.TvShow;
import com.belt.demo.models.User;
import com.belt.demo.repositories.RatingRepository;
import com.belt.demo.repositories.TvShowRepository;
import com.belt.demo.repositories.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final TvShowRepository tvShowRepository;
    private final RatingRepository ratingRepository;

    public UserService(UserRepository userRepository, TvShowRepository tvShowRepository, RatingRepository ratingRepository) {
        this.userRepository = userRepository;
        this.tvShowRepository = tvShowRepository;
        this.ratingRepository = ratingRepository;

    }

    // register user and hash their password
    public User registerUser(User user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return userRepository.save(user);
    }

    // find user by email
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // find user by id
    public User findUserById(Long id) {
        Optional<User> u = userRepository.findById(id);

        if (u.isPresent()) {
            return u.get();
        } else {
            return null;
        }
    }

    // authenticate user
    public boolean authenticateUser(String email, String password) {
        // first find the user by email
        User user = userRepository.findByEmail(email);
        // if we can't find it by email, return false
        if (user == null) {
            return false;
        } else {
            // if the passwords match, return true, else, return false
            if (BCrypt.checkpw(password, user.getPassword())) {
                return true;
            } else {
                return false;
            }

        }
    }
    public TvShow findTvShow(Long id) {
        Optional<TvShow> optional = tvShowRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }
    public TvShow createShow(TvShow tvShow){
    return tvShowRepository.save(tvShow);
    }
    public Rating createRating(Rating rating){
        return ratingRepository.save(rating);
    }
    public List<TvShow> allShows(){
        return tvShowRepository.findAll();
    }
    public void delete(Long id){
        TvShow tvShow=tvShowRepository.findById(id).orElse(null);
        List<Rating> ratings=tvShow.getRatings();
        for(Rating rate:ratings){
            ratingRepository.deleteById(rate.getId());
        }
        tvShowRepository.deleteById(id);
    }
}
