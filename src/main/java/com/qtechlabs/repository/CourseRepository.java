package com.qtechlabs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.qtechlabs.entity.CourseEntity;

@Repository
public interface CourseRepository extends CrudRepository<CourseEntity, Long>{

	
	
	
}
