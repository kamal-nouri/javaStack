package com.driver.license.services;

import com.driver.license.models.License;
import com.driver.license.models.Person;
import com.driver.license.repositories.LicenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LicenseService {
    private final LicenseRepository licenseRepository;

    public LicenseService(LicenseRepository licenseRepository) {
        this.licenseRepository = licenseRepository;
    }
    public List<License> allLicense() {
        return licenseRepository.findAll();
    }

    public License findLicense(Long id) {
        Optional<License> optionalSong = licenseRepository.findById(id);
        if (optionalSong.isPresent()) {
            return optionalSong.get();
        } else {
            return null;
        }
    }

    public License createLicense(License license) {
        return licenseRepository.save(license);
    }

}
