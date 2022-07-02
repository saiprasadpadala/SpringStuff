package com.ssl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssl.entities.Role;
import com.ssl.service.RoleServiceImpl;

@RestController
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private RoleServiceImpl roleService;
	 
	@PostMapping("/")
	public ResponseEntity<Role> addRole(@RequestBody Role role) {
		Role addedRole = roleService.addRole(role);
	    return new ResponseEntity<Role>(addedRole, HttpStatus.OK);
	}
	
	@PutMapping("/")
	public ResponseEntity<Role> updateRole(@RequestBody Role role) {
		Role addedRole = roleService.addRole(role);
	    return new ResponseEntity<Role>(addedRole, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Role> getRoleById(@PathVariable("id") long roleId) {
		Role role = roleService.getRoleById(roleId);
	    return new ResponseEntity<Role>(role, HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Role>> getAllRoles() {
		List<Role> roles = roleService.getAllRoles();
	    return new ResponseEntity<List<Role>>(roles, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteRoleById(@PathVariable("id") long roleId) {
		boolean role = roleService.deleteRoleById(roleId);
	    return new ResponseEntity<Boolean>(role, HttpStatus.OK);
	}
	
	@DeleteMapping("/")
	public ResponseEntity<Boolean> deleteAllRoles() {
		boolean role = roleService.deleteAllRoles();
	    return new ResponseEntity<Boolean>(role, HttpStatus.OK);
	}
}