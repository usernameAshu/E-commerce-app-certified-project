package com.edureka.userms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@GetMapping
	public ResponseEntity<List<UserDetails>> getAllUsers() {
		LOGGER.info("Getting list of users from the service layer");
		return service.getAllUsers();
	}

	@GetMapping(path = "/{userRole}", 
									 produces =   { MediaType.APPLICATION_JSON_VALUE, 
											   MediaType.APPLICATION_XML_VALUE } )
	public ResponseEntity<List<UserDetails>> getUsersByRole(@PathVariable String userRole) {
		LOGGER.info("Getting list of users from the service layer on the basis of ROLES");
		return service.findByUserRole(userRole);
	}
	
	@GetMapping(path ="/active" , produces =   { MediaType.APPLICATION_JSON_VALUE, 
			   									 MediaType.APPLICATION_XML_VALUE } )
	public ResponseEntity<List<UserDetails>> getActiveUsers() {
		LOGGER.info("Getting list of active users from the service layer");
		return service.getActiveUsers();
	}
	
}

