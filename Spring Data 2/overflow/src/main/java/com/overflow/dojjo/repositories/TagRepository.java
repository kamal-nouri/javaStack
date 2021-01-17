package com.overflow.dojjo.repositories;

import com.overflow.dojjo.models.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends CrudRepository<Tag,Long> {
    List<Tag>findAll();
    Tag findBySubject(String subject);

}
