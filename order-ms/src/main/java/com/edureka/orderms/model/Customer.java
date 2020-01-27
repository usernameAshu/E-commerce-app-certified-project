package com.edureka.orderms.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer_data")
public class Customer {
	
	@Id
	@Column(name="Customer_ID")
	private Long customerId;
	
	@Column(name="Last_Name")
	private String lastName;
	
	@Column(name="First_Name")
	private String firstName;
	
	@Column(name="Username")
	private String username;
	
	@Column(name="Password")
	private String password;
	
	//private List<OrderDetails> orders = new ArrayList<>();

}
