package com.belt.demo.repositories;

import com.belt.demo.models.TvShow;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TvShowRepository extends CrudRepository<TvShow,Long> {
    List<TvShow> findAll();


}
