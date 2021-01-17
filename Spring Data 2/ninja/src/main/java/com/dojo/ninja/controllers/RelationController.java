package com.dojo.ninja.controllers;

import com.dojo.ninja.models.Dojo;
import com.dojo.ninja.models.Ninja;
import com.dojo.ninja.services.RelationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RelationController {
    private final RelationService relationService;

    public RelationController(RelationService relationService) {
        this.relationService = relationService;
    }

    @RequestMapping("")
    public String main(Model model) {
        List<Dojo> dojos = relationService.allDojos();
        model.addAttribute("dojos", dojos);
        return "root.jsp";
    }

    @RequestMapping("/dojos/new")
    public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
        return "newdojo.jsp";
    }

    @RequestMapping(value = "/dojos", method = RequestMethod.POST)
    public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
        if (result.hasErrors()) {
            return "newdojo.jsp";
        } else {
            Dojo dojo1 = relationService.createDojos(dojo);
            return "redirect:/";
        }
    }
    @RequestMapping("/ninjas/new")
    public String newNinja(@ModelAttribute("ninja") Ninja ninja,Model model) {
        List<Dojo> dojos = relationService.allDojos();
        model.addAttribute("dojos", dojos);
        return "newninja.jsp";
    }
    @RequestMapping(value = "/ninjas", method = RequestMethod.POST)
    public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
        if (result.hasErrors()) {
            return "newninja.jsp";
        } else {
            Ninja ninja1 = relationService.createNinjas(ninja);
            return "redirect:/";
        }
    }
    @RequestMapping("/dojos/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        Dojo dojo = relationService.findDojos(id);
        model.addAttribute("dojo" ,dojo);
        return "show.jsp";
    }

}
