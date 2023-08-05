package com.qtechlabs.service;

import java.util.List;

import com.qtechlabs.dto.CourseDTO;

public interface CourseService {

	public CourseDTO createCourse(CourseDTO courseDTO);
	public CourseDTO getCourse(Long courseId);
	public List<CourseDTO> getAllCourse();
	public CourseDTO deleteCourse(Long courseId);
	public CourseDTO updateCourse(Long courseId, CourseDTO courseDTO);

}
