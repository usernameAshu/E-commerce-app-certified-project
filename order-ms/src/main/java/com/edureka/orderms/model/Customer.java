package com.edureka.orderms.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	@OneToMany(cascade = CascadeType.ALL, targetEntity = OrderDetails.class, mappedBy = "customer" , fetch = FetchType.LAZY)
	private List<OrderDetails> orders = new ArrayList<>();


	public Long getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	
	public List<OrderDetails> getOrders() {
		return orders;
	}


	public void setOrders(List<OrderDetails> orders) {
		this.orders = orders;
	}

	
	
}
