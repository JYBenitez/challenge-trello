package com.demo.managment.repository;

import com.demo.managment.model.CardEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends CrudRepository<CardEntity, Integer> {
}
