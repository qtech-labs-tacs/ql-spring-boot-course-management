package com.qtechlabs.service;

import java.util.List;

import com.qtechlabs.dto.CourseDTO;

public interface CourseService {

	public boolean createCourse(CourseDTO courseDTO);
	public CourseDTO getCourse(Long courseId);
	public List<CourseDTO> getAllCourse();
	public boolean deleteCourse(Long courseId);
	public boolean updateCourse(Long courseId, CourseDTO courseDTO);

}
