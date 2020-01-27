package com.edureka.orderms.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_data")
public class OrderDetails {

	@Id
	private Long orderId;
//	private Customer customer;
	private Date ordered;
	private String status;
}
