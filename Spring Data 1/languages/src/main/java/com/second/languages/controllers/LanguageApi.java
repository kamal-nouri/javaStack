package com.second.languages.controllers;

import com.second.languages.models.Language;
import com.second.languages.services.LanguageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LanguageApi {
private final LanguageService languageService;

    public LanguageApi(LanguageService languageService) {
        this.languageService = languageService;
    }
    @RequestMapping("/api/languages")
    public List<Language> index(){
        return languageService.allLanguages();
    }
    @RequestMapping(value = "/api/languages",method = RequestMethod.POST)
    public Language create(@RequestParam(value = "name")String name,@RequestParam(value = "creator")String creator,@RequestParam(value = "current_version")Integer current_version){
        Language language=new Language(name,creator,current_version);
        return languageService.createLanguage(language);
    }
    @RequestMapping("/api/languages/{id}")
    public Language show(@PathVariable("id") Long id){
        Language language=languageService.findLanguage(id);
        return language;
    }


}
