package com.validation.test.controllers;

import com.validation.test.models.User;
import com.validation.test.services.UserService;
import com.validation.test.validator.UserValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UserController {
    private final UserService userService;
    private final UserValidator userValidator;

    public UserController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }


    @RequestMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "registrationPage.jsp";
    }

    @RequestMapping("/login")
    public String login() {
        return "loginPage.jsp";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        userValidator.validate(user,result);
        if (result.hasErrors()) {
            return "registrationPage.jsp";
        }
        User user1 = userService.registerUser(user);
        session.setAttribute("userId", user1.getId());
        return "redirect:/home";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
            boolean isAuthenticate = userService.authenticateUser(email, password);
            if (isAuthenticate) {
                User user = userService.findByEmail(email);
                session.setAttribute("userId", user.getId());
                return "redirect:/home";
            } else {
                model.addAttribute("errors", "Invalid");
                return "loginPage.jsp";
            }
        }

        @RequestMapping("/home")
        public String home (HttpSession session, Model model) {
            if (session.getAttribute("userId") != null) {
                return "redirect:/login";
            } else {
                Long userId = (Long) session.getAttribute("userId");
                User user = userService.findUserById(userId);
                model.addAttribute("user", user);
                return "homePage.jsp";
            }
        }

        @RequestMapping("/logout")
        public String logout (HttpSession session){
            session.invalidate();
            return "redirect:/registration";
        }
    }
