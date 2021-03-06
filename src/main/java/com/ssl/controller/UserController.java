package com.ssl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssl.entities.User;
import com.ssl.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@PostMapping("/")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		User addedUser = userService.addUser(user);
	    return new ResponseEntity<User>(addedUser, HttpStatus.OK);
	}
	
	@PutMapping("/")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		User updatedUser = userService.addUser(user);
	    return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") long userId) {
		User user = userService.getUserById(userId);
	    return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userService.getAllUsers();
	    return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteUserById(@PathVariable("id") long userId) {
		boolean isDeleted = userService.deleteUserById(userId);
	    return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);
	}
	
	@DeleteMapping("/")
	public ResponseEntity<Boolean> deleteAllUsers() {
		boolean isDeleted = userService.deleteAllUsers();
	    return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);
	}
	
	@GetMapping("/roleId/{roleId}")
	public ResponseEntity<List<User>> getAllUsersByRoleId(@PathVariable("roleId") long roleId) {
		List<User> users = userService.getUsersByRoleId(roleId);
	    return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@GetMapping("/roleName/{roleName}")
	public ResponseEntity<List<User>> getAllUsersByRoleName(@PathVariable("roleName") String roleName) {
		List<User> users = userService.getUsersByRoleName(roleName);
	    return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
}
