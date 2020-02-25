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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
	@Pattern(regexp = "[^0-9]")
	@NotNull(message = "Last Name shouldn't be NULL")
	private String lastName;
	
	@Column(name="First_Name")
	@Pattern(regexp = "[^0-9]")
	@NotNull(message = "First Name shouldn't be NULL, shouldn't include digits")
	private String firstName;
	
	@Column(name="Username")
	@NotNull(message = "Username shouldn't be NULL")
	private String username;
	
	@Column(name="Password")
	@NotNull(message = "Password cannot be NULL")
	@Size(min = 3,max = 8,message = "Password has to be between 3 and 8 charecters")
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
