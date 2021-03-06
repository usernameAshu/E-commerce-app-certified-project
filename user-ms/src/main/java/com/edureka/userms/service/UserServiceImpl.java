package com.edureka.userms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.edureka.userms.models.UserDetails;
import com.edureka.userms.repository.UserRepository;

@Service
public class UserServiceImpl implements UserServiceInterface {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public ResponseEntity<List<UserDetails>> getAllUsers() {
		return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<UserDetails>> findByUserRole(String userRole) {
		return new ResponseEntity<>(userRepository.findByUserRole(userRole), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<UserDetails>> getActiveUsers() {
		return new ResponseEntity<>(userRepository.getActiveUsers(),HttpStatus.OK);
	}

}
