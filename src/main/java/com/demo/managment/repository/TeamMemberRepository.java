package com.demo.managment.repository;

import com.demo.managment.model.TeamMemberEntity;
import org.springframework.data.repository.CrudRepository;

public interface TeamMemberRepository extends CrudRepository<TeamMemberEntity, Integer> {

}
