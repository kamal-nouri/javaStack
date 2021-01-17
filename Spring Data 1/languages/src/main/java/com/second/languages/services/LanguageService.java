package com.second.languages.services;

import com.second.languages.models.Language;
import com.second.languages.repositories.LanguageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageService {
    private final LanguageRepository languageRepository;

    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }
    public List<Language> allLanguages(){
        return languageRepository.findAll();
    }
    public Language createLanguage(Language language){
        return languageRepository.save(language);
    }
    public Language findLanguage(Long id){
        Optional<Language>optionalLanguage=languageRepository.findById(id);
        if (optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }
    public Language updateLanguage(Language language){
        Language updatedLanguage=languageRepository.findById(language.getId()).orElse(null);
        assert updatedLanguage != null;
        updatedLanguage.setName(language.getName());
        updatedLanguage.setCreator(language.getCreator());
        updatedLanguage.setCurrentVersion(language.getCurrentVersion());
        languageRepository.save(updatedLanguage);
        return language;
    }
    public void delete(Long id){
        languageRepository.deleteById(id);
    }

}
