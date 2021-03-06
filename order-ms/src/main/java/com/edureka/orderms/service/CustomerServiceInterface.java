package com.edureka.orderms.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.edureka.orderms.model.Customer;
import com.edureka.orderms.model.OrderDetails;

public interface CustomerServiceInterface {

	ResponseEntity<List<OrderDetails>> getOrdersForCustomer(Long customerId);

	ResponseEntity<List<Customer>> getCustomers();

}
