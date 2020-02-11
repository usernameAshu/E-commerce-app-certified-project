package com.edureka.userms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.edureka.userms.models.UserDetails;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, Long> {

	
	public List<UserDetails>  findByUserRole(String userRole);
	
	@Query(value = "SELECT * FROM user_details u WHERE u.active_status IS true" ,
			nativeQuery = true)
	public List<UserDetails> getActiveUsers() ;
	
} 
