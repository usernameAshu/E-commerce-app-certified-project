package com.edureka.orderms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_data")
@Data
@NoArgsConstructor
public class OrderDetails {

	@Id
	@Column(name = "ORDER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;

	@ManyToOne
	@JoinColumn(name = "customerid" , insertable = false , updatable = false , nullable = true)
	private Customer customer;

	private Long customerid;

	public Long getCustomerid() {
		return customerid;
	}

	public void setCustomerid(Long customerid) {
		this.customerid = customerid;
	}

	@Column(name = "order_date")
	private Date orderDate;

	@Column(name = "order_status")
	private String status;


	@JsonBackReference
	public Customer getCustomer() {
		return customer;
	}

	
}
