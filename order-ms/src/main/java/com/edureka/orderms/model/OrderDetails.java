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

@Entity
@Table(name = "order_data")
public class OrderDetails {

	@Id
	@Column(name = "ORDER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;

	@ManyToOne
	@JoinColumn(name = "CUSTOMER_ID")
	private Customer customer;
	
	@Column(name = "order_date")
	private Date orderDate;
	
	@Column(name = "order_status")
	private String status;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getOrdered() {
		return orderDate;
	}

	public void setOrdered(Date ordered) {
		this.orderDate = ordered;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
