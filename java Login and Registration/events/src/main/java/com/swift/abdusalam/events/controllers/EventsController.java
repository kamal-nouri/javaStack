package com.swift.abdusalam.events.controllers;

import com.swift.abdusalam.events.models.Event;
import com.swift.abdusalam.events.models.Message;
import com.swift.abdusalam.events.models.User;
import com.swift.abdusalam.events.services.EventsService;
import com.swift.abdusalam.events.validator.UserValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class EventsController {
    private final EventsService eventsService;
    private final UserValidator userValidator;

    public EventsController(EventsService eventsService, UserValidator userValidator) {
        this.eventsService = eventsService;
        this.userValidator = userValidator;
    }
    @RequestMapping("/")
    public String registerForm(@ModelAttribute("user") User user,HttpSession session) {
        if(session.getAttribute("userId")!=null){
            return "redirect:/events";
        }
        return "root.jsp";
    }
    @RequestMapping(value="/registration", method= RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session,Model model) {
        userValidator.validate(user, result);
        if(result.hasErrors()){
            return "root.jsp";
        }
        else {
            User user1 = eventsService.registerUser(user);
            session.setAttribute("userId", user1.getId());
            return "redirect:/events";
        }
    }
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@ModelAttribute("user") User user1,@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session, Model model) {
        if(eventsService.authenticateUser(email,password)){
            User user = eventsService.findByEmail(email);
            session.setAttribute("userId",user.getId());
            return "redirect:/events";
        }
        else{
            model.addAttribute("loginError","Invalid Email/Password");
            return "root.jsp";
        }
    }
    @RequestMapping("/events")
    public String home(HttpSession session, Model model,@ModelAttribute("event")Event event) {
        if(session.getAttribute("userId")==null){
            return "redirect:/";
        }
        else {
            User user = eventsService.findUserById((Long) session.getAttribute("userId"));
            model.addAttribute("user",user);
            model.addAttribute("eventwithstate",eventsService.allEventsWithState(user.getState()));
            model.addAttribute("eventwithoutstate",eventsService.allEventsWithoutState(user.getState()));
            return "events.jsp";
        }
    }
    @RequestMapping(value = "/events",method = RequestMethod.POST)
    public String createEvent(@Valid @ModelAttribute("event")Event event,BindingResult result,HttpSession session,Model model){
        if(result.hasErrors()){
            User user = eventsService.findUserById((Long) session.getAttribute("userId"));
            model.addAttribute("user",user);
            return "events.jsp";
        }
        else{
            User user=eventsService.findUserById((Long) session.getAttribute("userId"));
            Event event1=eventsService.createEvent(event,user);
            return "redirect:/events";
        }
    }
    @RequestMapping("/events/{id}/edit")
    public String editEvent(@PathVariable("id")Long id,@ModelAttribute("event")Event event,Model model,HttpSession session){
        if(session.getAttribute("userId")==null){
            return "redirect:/";
        }
        model.addAttribute("event",eventsService.findEvent(id));
        return "edit.jsp";
    }
    @RequestMapping(value = "/events/{id}/edit",method = RequestMethod.PUT)
    public String updateEvent(@PathVariable("id")Long id,@Valid @ModelAttribute("event")Event event,BindingResult result){
        if(result.hasErrors()){
            return "edit.jsp";
        }else{
            eventsService.updateEvent(event);
            return "redirect:/events";

        }

    }
    @RequestMapping("/events/{id}")
    public String showEvent(@PathVariable("id")Long id, @ModelAttribute("message")Message message, Model model,HttpSession session){
        if(session.getAttribute("userId")==null){
            return "redirect:/";
        }
        model.addAttribute("event",eventsService.findEvent(id));
        model.addAttribute("eventnumber",eventsService.countByJoinedUsers(id));
        return "show.jsp";
    }
    @RequestMapping(value = "/events/{id}",method = RequestMethod.POST)
    public String addMessage(@PathVariable("id")Long event_id,@Valid @ModelAttribute("message")Message message,BindingResult result, Model model,HttpSession session){
        if(result.hasErrors()) {
            model.addAttribute("event", eventsService.findEvent(event_id));
            return "show.jsp";
        }else{
            eventsService.createMessage(message,event_id,(Long)session.getAttribute("userId"));
            return "redirect:/events/"+event_id;
        }
    }
    @RequestMapping("/events/{id}/delete")
    public String deleteEvent(@PathVariable("id")Long id){
        eventsService.deleteEvent(id);
        return "redirect:/events";
    }
    @RequestMapping("events/{id}/join")
    public String joinEvent(@PathVariable("id")Long event_id,HttpSession session){
        Long user_id=(Long)session.getAttribute("userId");
        eventsService.joinEvent(event_id,user_id);
        return "redirect:/events";
    }
    @RequestMapping("events/{id}/cancel")
    public String cancelEvent(@PathVariable("id")Long event_id,HttpSession session){
        Long user_id=(Long)session.getAttribute("userId");
        eventsService.cancelEvent(event_id,user_id);
        return "redirect:/events";
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
