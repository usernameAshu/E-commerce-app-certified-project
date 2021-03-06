package com.edureka.orderms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.edureka.orderms.model.Customer;
import com.edureka.orderms.model.OrderDetails;
import com.edureka.orderms.repository.CustomerRepository;

@Service
public class CustomerService implements CustomerServiceInterface {

	@Autowired
	private CustomerRepository customerRepository ;
	

	@Override
	public ResponseEntity<List<OrderDetails>> getOrdersForCustomer(Long customerId) {

		Optional<Customer> customer = customerRepository.findById(customerId);
		
		if(customer.isPresent()) {
			Customer newCustomer = customer.get();
			return new ResponseEntity<>(newCustomer.getOrders(),HttpStatus.OK);
		}
		
		return null;
	}

	@Override
	public ResponseEntity<List<Customer>> getCustomers() {
		return new ResponseEntity<List<Customer>>(customerRepository.findAll(), HttpStatus.OK);
		
	}
}
