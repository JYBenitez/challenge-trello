package com.demo.managment.repository;

import com.demo.managment.model.LabelEntity;
import org.springframework.data.repository.CrudRepository;

public interface LabelRepository extends CrudRepository<LabelEntity, Integer> {
}
