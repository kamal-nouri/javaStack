package com.swift.abdusalam.events.repositories;

import com.swift.abdusalam.events.models.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends CrudRepository<Message,Long> {
}
