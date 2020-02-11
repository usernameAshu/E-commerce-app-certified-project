package com.edureka.userms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edureka.userms.models.UserDetails;
import com.edureka.userms.service.UserServiceInterface;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserServiceInterface service;

	@GetMapping
	public ResponseEntity<List<UserDetails>> getAllUsers() {
		return service.getAllUsers();
	}

	@GetMapping(path = "/{userRole}", 
									 produces =   { MediaType.APPLICATION_JSON_VALUE, 
											   MediaType.APPLICATION_XML_VALUE } )
	public ResponseEntity<List<UserDetails>> getUsersByRole(@PathVariable String userRole) {
		return service.findByUserRole(userRole);
	}
	
	@GetMapping(path ="/active" , produces =   { MediaType.APPLICATION_JSON_VALUE, 
			   									 MediaType.APPLICATION_XML_VALUE } )
	public ResponseEntity<List<UserDetails>> getActiveUsers() {
		return service.getActiveUsers();
	}
	
}

