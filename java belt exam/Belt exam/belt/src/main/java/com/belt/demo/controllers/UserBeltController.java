package com.belt.demo.controllers;

import com.belt.demo.models.Rating;
import com.belt.demo.models.TvShow;
import com.belt.demo.models.User;
import com.belt.demo.services.UserService;
import com.belt.demo.validator.UserValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class UserBeltController {
    private final UserService userService;
    private final UserValidator userValidator;

    public UserBeltController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }


    @RequestMapping("/")
    public String registerForm(@ModelAttribute("user") User user, HttpSession session) {
        if (session.getAttribute("userId") != null) {
            return "redirect:/home";
        }
        return "root.jsp";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session, Model model) {
        userValidator.validate(user, result);
        if (result.hasErrors()) {
            return "root.jsp";
        } else {
            User user1 = userService.registerUser(user);
            session.setAttribute("userId", user1.getId());
            return "redirect:/home";
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginUser(@ModelAttribute("user") User user1, @RequestParam("email") String email, @RequestParam("password") String password, HttpSession session, Model model) {
        if (userService.authenticateUser(email, password)) {
            User user = userService.findByEmail(email);
            session.setAttribute("userId", user.getId());
            return "redirect:/home";
        } else {
            model.addAttribute("loginError", "Invalid Email/Password");
            return "root.jsp";
        }
    }


    @RequestMapping("/home")
    public String home(HttpSession session, Model model,@ModelAttribute("tvShow") TvShow tvShow) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/";
        } else {
            Long userId = (Long) session.getAttribute("userId");
            User user = userService.findUserById(userId);
            List<TvShow> tvShow1=userService.allShows();

            model.addAttribute("tvShows",tvShow1);
            model.addAttribute("user", user);
            return "home.jsp";
        }
    }

    @RequestMapping("/shows/new")
    public String newShow(@ModelAttribute("tvShow") TvShow tvShow,HttpSession session) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/";
        }

        return "new.jsp";
    }

    @RequestMapping(value = "/addshow", method = RequestMethod.POST)
    public String createShow(@Valid @ModelAttribute("tvShow") TvShow tvShow, BindingResult result) {
        if (result.hasErrors()) {
            return "new.jsp";
        } else {
            TvShow tvShow1 = userService.createShow(tvShow);
            return "redirect:/home";
        }
    }
    @RequestMapping("/shows/{id}")
    public String Show(@PathVariable("id")Long id, @ModelAttribute("tvShow") TvShow tvShow, HttpSession session,Model model) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/";
        }
        TvShow tvShow1=userService.findTvShow(id);
        model.addAttribute("tvShow",tvShow1);
        return "showtv.jsp";
    }
    @RequestMapping("/shows/{id}/edit")
    public String editShow(@PathVariable("id")Long id, @ModelAttribute("tvShow") TvShow tvShow, HttpSession session,Model model) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/";
        }
        TvShow tvShow1=userService.findTvShow(id);
        model.addAttribute("tvShow",tvShow1);
        return "edit.jsp";
    }
    @RequestMapping("/shows/{id}/update")
    public String updateShow(@PathVariable("id")Long id,  @RequestParam("title") String title, @RequestParam("network") String network,Model model, HttpSession session) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/";
        }
        TvShow tvShow1=userService.findTvShow(id);
        tvShow1.setTitle(title);
        tvShow1.setNetwork(network);
        userService.createShow(tvShow1);
        return "redirect:/home";
    }
    @RequestMapping("/shows/{id}/delete")
    public String deleteShow(@PathVariable("id")Long id,HttpSession session) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/";
        }
        userService.delete(id);
        return "redirect:/home";
    }
    @RequestMapping("/shows/{id}/rate")
    public String rateShow(@PathVariable("id")Long id,  @RequestParam("rate") double rate, Model model, HttpSession session) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/";
        }
        TvShow tvShow1=userService.findTvShow(id);
        Long userId = (Long) session.getAttribute("userId");
        User user = userService.findUserById(userId);
        Rating rating=new Rating(rate,user,tvShow1);
        rating.setRate(rate);
        rating.setTvShow(tvShow1);
        rating.setUser(user);
        userService.createRating(rating);
        return "redirect:/shows/"+id;
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }


}
