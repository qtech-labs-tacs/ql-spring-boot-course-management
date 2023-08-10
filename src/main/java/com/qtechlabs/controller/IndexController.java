package com.qtechlabs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

	private static final Logger log = LoggerFactory.getLogger(IndexController.class);

	
	@GetMapping("/")
	public ResponseEntity<String> index() {
		log.info("API");
		return new ResponseEntity<>("Welcome User", HttpStatus.OK);
	}

	
}
