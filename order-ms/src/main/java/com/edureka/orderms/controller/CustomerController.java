package com.edureka.orderms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edureka.orderms.model.Customer;
import com.edureka.orderms.model.OrderDetails;
import com.edureka.orderms.service.CustomerServiceInterface;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {
	
	@Autowired
	CustomerServiceInterface customerService ;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
	
	@CrossOrigin(origins = "*")	
	@GetMapping
	public ResponseEntity<List<Customer>> getCustomers() {
		LOGGER.info("Getting All Customers from Service class");
		return customerService.getCustomers();
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping(path ="/{customerId}/orders")
	public ResponseEntity<List<OrderDetails>> getOrdersForCustomer(@PathVariable Long customerId) {
		LOGGER.info("Getting customer by ID from Service class");
		return customerService.getOrdersForCustomer(customerId);
	}

}
