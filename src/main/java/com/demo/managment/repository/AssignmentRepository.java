package com.demo.managment.repository;

import com.demo.managment.model.AssignmentEntity;
import org.springframework.data.repository.CrudRepository;

public interface AssignmentRepository extends CrudRepository<AssignmentEntity, Integer> {
}
