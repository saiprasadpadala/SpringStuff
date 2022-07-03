package com.ssl.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class TestController {
	
	@GetMapping("/private")
	public ResponseEntity<String> afterLoginSuccess() {
		String message = "This is private page";
	    return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
	@GetMapping("/public")
	public ResponseEntity<String> beforeLogin() {
		String message = "This is public page";
	    return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
	@GetMapping("/admin")
	public ResponseEntity<String> afterLoginAdminOnly() {
		String message = "This is Admin page";
	    return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
	@GetMapping("/userpage")
	public ResponseEntity<String> afterLoginUserOnly() {
		String message = "This is User page";
	    return new ResponseEntity<String>(message, HttpStatus.OK);
	}
}
