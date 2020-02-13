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

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="customer_data")
@NoArgsConstructor
@Data
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
	
	@OneToMany(cascade = CascadeType.ALL, 
			targetEntity = OrderDetails.class,
			mappedBy = "customer" ,
			fetch = FetchType.LAZY)
	private List<OrderDetails> orders = new ArrayList<>();


	@JsonManagedReference
	public List<OrderDetails> getOrders() {
		return orders;
	}
	
	
}
