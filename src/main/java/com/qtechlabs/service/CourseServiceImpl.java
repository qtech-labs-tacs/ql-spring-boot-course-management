package com.qtechlabs.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qtechlabs.dto.CourseDTO;
import com.qtechlabs.entity.Course;
import com.qtechlabs.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepsitory;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public boolean createCourse(CourseDTO courseDTO) {

		Course course = modelMapper.map(courseDTO, Course.class);
		
		// INSERT 
		Course save = courseRepsitory.save(course);
	
		return true;
	}

	
	
	@Override
	public CourseDTO getCourse(Long courseId) {
		
		Optional<Course> courseOptional = courseRepsitory.findById(courseId);
		
		if (courseOptional.isPresent()) {
			Course courseEntity = courseOptional.get();
			
			// SELECT
			CourseDTO courseDTO = modelMapper.map(courseEntity, CourseDTO.class);
			return courseDTO;
		}
		return null;
	}

	@Override
	public boolean updateCourse(Long courseId, CourseDTO courseDTO) {
		Optional<Course> course = courseRepsitory.findById(courseId);
		
		if (course.isPresent()) {
			Course courseEntity = course.get();
			courseEntity.setFees(courseDTO.getFees());
			
			//UPDATE
			courseRepsitory.save(courseEntity);
		}

		return true;
	}

	@Override
	public boolean deleteCourse(Long courseId) {

		//DELETE
		courseRepsitory.deleteById(courseId);
		return true;
	
	}
	
	
	@Override
	public List<CourseDTO> getAllCourse() {
		return null;
	}

}
