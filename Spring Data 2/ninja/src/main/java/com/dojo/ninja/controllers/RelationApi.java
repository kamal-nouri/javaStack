package com.dojo.ninja.controllers;

import com.dojo.ninja.models.Dojo;
import com.dojo.ninja.models.Ninja;
import com.dojo.ninja.services.RelationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RelationApi {
    private final RelationService relationService;

    public RelationApi(RelationService relationService) {
        this.relationService = relationService;
    }

    @RequestMapping("/api/dojos")
    public List<Dojo> index() {
        return relationService.allDojos();
    }

    @RequestMapping("/api/ninjas")
    public List<Ninja> index1() {
        return relationService.allNinjas();
    }
    @RequestMapping(value = "/api/dojos", method = RequestMethod.POST)
    public Dojo create(@RequestParam(value = "name") String name) {
        Dojo dojo = new Dojo(name);
        return relationService.createDojos(dojo);
    }

    @RequestMapping("/api/dojos/{id}")
    public Dojo show(@PathVariable("id") Long id) {
        Dojo dojo = relationService.findDojos(id);
        return dojo;
    }
    @RequestMapping(value = "/api/ninjas", method = RequestMethod.POST)
    public Ninja create1(@RequestParam(value = "firstName") String firstName,@RequestParam(value = "lastName") String lastName,@RequestParam(value = "age") int age,@RequestParam(value = "dojo") Dojo dojo) {
        Ninja ninja = new Ninja(firstName,lastName,age,dojo);
        return relationService.createNinjas(ninja);
    }

    @RequestMapping("/api/ninjas/{id}")
    public Ninja show1(@PathVariable("id") Long id) {
        Ninja ninja = relationService.findNinjas(id);
        return ninja;
    }
}