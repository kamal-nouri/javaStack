package com.driver.license.controllers;

import com.driver.license.models.License;
import com.driver.license.models.Person;
import com.driver.license.services.LicenseService;
import com.driver.license.services.PersonService;
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
public class PersonController {
    private final PersonService personService;
    private final LicenseService licenseService;

    public PersonController(PersonService personService, LicenseService licenseService) {
        this.personService = personService;
        this.licenseService = licenseService;
    }

    @RequestMapping("")
    public String main() {
        return "redirect:/person/new";
    }

    @RequestMapping("/person/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "new.jsp";
    }

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
        if (result.hasErrors()) {
            return "new.jsp";
        } else {
            Person person1 = personService.createPerson(person);
            return "redirect:/person/" + person1.getId();
        }
    }

    @RequestMapping("/person/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        Person person = personService.findPerson(id);
        model.addAttribute("person", person);
        return "show.jsp";
    }

    @RequestMapping("/license/new")
    public String newLicense(@ModelAttribute("license") License license, Model model) {
        List<Person> persons = personService.allPerson();
        model.addAttribute("persons", persons);
        return "new2.jsp";
    }

    @RequestMapping(value = "/license", method = RequestMethod.POST)
    public String createLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
        if (result.hasErrors()) {
            return "new2.jsp";
        } else {
            License license1 = licenseService.createLicense(license);
            return "redirect:/license";
        }

    }
}