package com.qtechlabs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.qtechlabs.entity.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long>{

	
	public Course findByCourseId(Long courseId);
	
	
}
