package com.qtechlabs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qtechlabs.dto.CourseDTO;
import com.qtechlabs.entity.CourseEntity;
import com.qtechlabs.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepsitory;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CourseDTO createCourse(CourseDTO courseDTO) {

		CourseEntity courseEntity = modelMapper.map(courseDTO, CourseEntity.class);
		courseRepsitory.save(courseEntity);

		return courseDTO;
	}

	@Override
	public CourseDTO getCourse(Long courseId) {
		Optional<CourseEntity> courseOptional = courseRepsitory.findById(courseId);
		if(courseOptional.isPresent()) {
			CourseEntity courseEntity = courseOptional.get();
			CourseDTO courseDTO = modelMapper.map(courseEntity, CourseDTO.class);
			return courseDTO;
		}
		return null;
	}

	@Override
	public CourseDTO updateCourse(Long courseId, CourseDTO courseDTO) {
			Optional<CourseEntity> course = courseRepsitory.findById(courseId);
			if(course.isPresent()) {
				
			}
			
		return courseDTO;
	}

	@Override
	public CourseDTO deleteCourse(Long courseId) {
		return null;
	}

	@Override
	public List<CourseDTO> getAllCourse() {
		List<CourseDTO> listOfCourses = new ArrayList<CourseDTO>();
		Iterable<CourseEntity> courses = courseRepsitory.findAll();
		courses.forEach( (course) -> {
			listOfCourses.add(modelMapper.map(course, CourseDTO.class)); 
			}
		);
		return listOfCourses;
	}

}
