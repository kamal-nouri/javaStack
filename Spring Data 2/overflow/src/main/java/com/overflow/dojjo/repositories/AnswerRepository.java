package com.overflow.dojjo.repositories;

import com.overflow.dojjo.models.Answer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends CrudRepository<Answer,Long> {
    List<Answer>findAll();
}
