package com.dojo.ninja.services;

import com.dojo.ninja.models.Dojo;
import com.dojo.ninja.models.Ninja;
import com.dojo.ninja.repositories.DojoRepository;
import com.dojo.ninja.repositories.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RelationService {
    private final DojoRepository dojoRepository;
    private final NinjaRepository ninjaRepository;

    public RelationService(DojoRepository dojoRepository, NinjaRepository ninjaRepository) {
        this.dojoRepository = dojoRepository;
        this.ninjaRepository = ninjaRepository;
    }

    public List<Dojo> allDojos() {
        return dojoRepository.findAll();
    }

    public List<Ninja> allNinjas() {
        return ninjaRepository.findAll();
    }

    public Dojo findDojos(Long id) {
        Optional<Dojo> optionalSong = dojoRepository.findById(id);
        if (optionalSong.isPresent()) {
            return optionalSong.get();
        } else {
            return null;
        }
    }

    public Ninja findNinjas(Long id) {
        Optional<Ninja> optionalSong = ninjaRepository.findById(id);
        if (optionalSong.isPresent()) {
            return optionalSong.get();
        } else {
            return null;
        }
    }

    public Dojo createDojos(Dojo dojo) {
        return dojoRepository.save(dojo);
    }

    public Ninja createNinjas(Ninja ninja) {
        return ninjaRepository.save(ninja);
    }

}
