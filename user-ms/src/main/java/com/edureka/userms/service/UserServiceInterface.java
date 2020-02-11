package com.edureka.userms.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.edureka.userms.models.UserDetails;

public interface UserServiceInterface {

	public ResponseEntity<List<UserDetails>> getAllUsers();
	public ResponseEntity<List<UserDetails>> findByUserRole(String userRole);
	public ResponseEntity<List<UserDetails>> getActiveUsers() ;
}
