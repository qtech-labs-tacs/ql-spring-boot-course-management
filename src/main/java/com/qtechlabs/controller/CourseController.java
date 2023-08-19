package com.qtechlabs.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qtechlabs.dto.CourseDTO;
import com.qtechlabs.service.CourseService;

/**
 * 
 * @author faizan khan
 *
 */
@RestController
@RequestMapping("/api/v1/course")
public class CourseController {

	private static final Logger log = LoggerFactory.getLogger(CourseController.class);

	@Autowired
	private CourseService courseService;

	
	
	//-->  API 1  -- CREATE
	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createCourse(@RequestBody CourseDTO courseDTO) {
		log.info("Create API");
		courseService.createCourse(courseDTO);
		
		return new ResponseEntity<>("Course Created", HttpStatus.CREATED);
	}
	
	
	
	
	//-->  API 2 -- RETRIEVE
	@GetMapping("/{courseId}")
	public ResponseEntity<?> getCourse(@PathVariable Long courseId) {
		log.info("API");

		CourseDTO course = courseService.getCourse(courseId);
		if (course != null) {
			return new ResponseEntity<CourseDTO>(course, HttpStatus.CREATED);
		}
		return new ResponseEntity<>("No Record Found For This Course Id", HttpStatus.CREATED);
	}

	
	
	
	//-->  API 3 -- RETRIEVE
	@GetMapping("/")
	public ResponseEntity<List<CourseDTO>> getAllCourses() {
		log.info("API");
		List<CourseDTO> allCourse = courseService.getAllCourse();
		return new ResponseEntity<>(allCourse, HttpStatus.OK);
	}

	
	
	//--> API 4 -- UPDATE
	@PutMapping("/{courseId}")
	public ResponseEntity<String> updateCourse(@PathVariable Long courseId, @RequestBody CourseDTO courseDTO) {
		log.info("API");
		courseService.updateCourse(courseId, courseDTO);
		return new ResponseEntity<>("Course has been updated", HttpStatus.OK);
	}
	
	
	
	

	//-->  API 5 -- DELETE
	@DeleteMapping("/{courseId}")
	public ResponseEntity<String> deleteCourse(@PathVariable Long courseId) {
		log.info("API");
		courseService.deleteCourse(courseId);
		return new ResponseEntity<String>("Course has been deleted", HttpStatus.OK);
	}
	
	
	

}
