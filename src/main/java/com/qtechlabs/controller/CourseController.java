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

	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO courseDTO) {
		log.info("Create API");
		CourseDTO createCourse = courseService.createCourse(courseDTO);
		return new ResponseEntity<CourseDTO>(createCourse, HttpStatus.CREATED);
	}

	@GetMapping("/{courseId}")
	public ResponseEntity<CourseDTO> getCourse(@PathVariable Long courseId) {
		log.info("API");
		CourseDTO course = courseService.getCourse(courseId);
		return new ResponseEntity<CourseDTO>(course, HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<List<CourseDTO>> getAllCourses() {
		log.info("API");
		List<CourseDTO> allCourse = courseService.getAllCourse();
		return new ResponseEntity<>(allCourse, HttpStatus.OK);
	}

	@PutMapping("{courseId}")
	public ResponseEntity<CourseDTO> updateCourse(@PathVariable Long courseId, @RequestBody CourseDTO courseDTO) {
		log.info("API");
		CourseDTO updateCourse = courseService.updateCourse(courseId, courseDTO);
		return new ResponseEntity<CourseDTO>(updateCourse, HttpStatus.OK);
	}

	@DeleteMapping("/{courseId}")
	public ResponseEntity<CourseDTO> deleteCourse(@PathVariable Long courseId) {
		log.info("API");
		courseService.deleteCourse(courseId);
		return null;
	}

}
