package com.demo.managment.repository;

import com.demo.managment.model.TeamEntity;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<TeamEntity, Integer> {
}
