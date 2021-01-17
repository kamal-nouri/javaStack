package com.driver.license.repositories;

import com.driver.license.models.License;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LicenseRepository extends CrudRepository<License,Long> {
    List<License> findAll();
}
