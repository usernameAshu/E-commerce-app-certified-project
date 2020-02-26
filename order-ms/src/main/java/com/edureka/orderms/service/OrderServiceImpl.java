package com.edureka.orderms.service;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.edureka.orderms.controller.OrderController;
import com.edureka.orderms.exception.OrderNotFoundException;
import com.edureka.orderms.model.OrderDetails;
import com.edureka.orderms.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

	/*
	 * READ operation for fetching ALL orders
	 */
	@Override
	public ResponseEntity<List<OrderDetails>> getOrders() {
		LOGGER.info("Getting All Customers from Database class");
		return new ResponseEntity<>(orderRepository.findAll(), HttpStatus.OK);
	}

	/*
	 * READ by order id
	 */
	@Override
	public ResponseEntity<OrderDetails> getOrderById(@Valid Long orderId) {
		
		LOGGER.info("Getting Customers by id from Database class");
		if (orderRepository.findById(orderId).isPresent())
			return new ResponseEntity<>(orderRepository.findById(orderId).get(), HttpStatus.OK);

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

	/*
	 * POST operation for order creation
	 */
	@Override
	public ResponseEntity<OrderDetails> createOrder(@Valid OrderDetails orderDetails) {
		LOGGER.info("Creating Customer in Database");
		OrderDetails modelSaved = orderRepository.save(orderDetails);

		return new ResponseEntity<>(modelSaved, HttpStatus.CREATED);
	}

	/*
	 * PUT operation for order update if not found throw OrderNotFoundException
	 */

	@Override
	public ResponseEntity<Object> updateOrder(Long orderId, @Valid OrderDetails orderDetails) {
		LOGGER.info("Updating Customers from Database class");
		OrderDetails orderToUpdate = orderRepository.findById(orderId)
	    .orElseThrow(() -> new OrderNotFoundException("Order Doesn't Exists , please create an Order"));

		return new ResponseEntity<>(orderRepository.save(orderDetails), HttpStatus.OK);

	}

	/*
	 * DELETE operation for Order
	 */

	@Override
	public ResponseEntity<String> deleteOrderById(Long orderId) {
		LOGGER.info("Removing Customer object from Database class");
		orderRepository.deleteById(orderId);
		return new ResponseEntity<>("Record Deleted", HttpStatus.OK);
	}
}