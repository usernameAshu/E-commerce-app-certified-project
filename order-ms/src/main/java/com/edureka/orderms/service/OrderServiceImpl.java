package com.edureka.orderms.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.edureka.orderms.exception.OrderNotFoundException;
import com.edureka.orderms.model.OrderDetails;
import com.edureka.orderms.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderServiceInterface {

	@Autowired
	private OrderRepository orderRepository;

	/*
	 * READ operation for fetching ALL orders
	 */
	@Override
	public ResponseEntity<List<OrderDetails>> getOrders() {
		return new ResponseEntity<>(orderRepository.findAll(), HttpStatus.OK);
	}

	/*
	 * READ by order id
	 */
	@Override
	public ResponseEntity<OrderDetails> getOrder(Long orderId) {

		if (orderRepository.findById(orderId).isPresent())
			return new ResponseEntity<>(orderRepository.findById(orderId).get(), HttpStatus.OK);

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

	/*
	 * POST operation for order creation
	 */
	@Override
	public ResponseEntity<OrderDetails> createOrder(@Valid OrderDetails orderDetails) {

		OrderDetails modelSaved = orderRepository.save(orderDetails);

		return new ResponseEntity<>(modelSaved, HttpStatus.CREATED);
	}

	/*
	 * PUT operation for order update if not found throw OrderNotFoundException 
	 */

	@Override
	public ResponseEntity<Object> updateOrder(Long orderId, @Valid OrderDetails orderDetails) {
		OrderDetails orderToUpdate = orderRepository.findById(orderId)
				.orElseThrow(() -> new OrderNotFoundException("Order Doesn't Exists , please create an Order"));

		return new ResponseEntity<>(orderRepository.save(orderDetails), HttpStatus.OK);

	}
	
	/*
	 * DELETE operation for Order
	 */

	@Override
	public ResponseEntity<String> deleteOrder(Long orderId) {

		orderRepository.deleteById(orderId);
		return new ResponseEntity<>("Record Deleted", HttpStatus.OK);
	}
}