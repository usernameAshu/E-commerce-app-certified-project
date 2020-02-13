package com.edureka.userms.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_details")
@Data
@NoArgsConstructor
public class UserDetails {

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	@Column(name = "user_name")
	private String userName;

//	@Transient
	@Column(name = "password")
	private String password;

	@Column(name = "user_role")
	private String userRole;

	@Column(name = "active_status")
	private boolean activeStatus;

	
}
