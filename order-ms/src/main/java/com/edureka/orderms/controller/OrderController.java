package com.edureka.orderms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edureka.orderms.model.OrderDetails;
import com.edureka.orderms.repository.OrderRepository;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {

	/*
	 * Using repo in place of service, will change after adding methods in the
	 * service layer
	 */

	@Autowired
	private OrderRepository orderService;

	/*
	 * READ operation for fetching ALL orders
	 */

	@GetMapping
	public ResponseEntity<List<OrderDetails>> getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "20") int limit) {

		return new ResponseEntity<>(orderService.findAll(), HttpStatus.OK);
	}

	/*
	 * READ by order id
	 */
	@GetMapping(path = "/{orderId}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Object> getOrder(@PathVariable Long orderId) {

		if (orderService.findById(orderId).isPresent())
			return new ResponseEntity<>(orderService.findById(orderId).get(), HttpStatus.OK);

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	/*
	 * POST operation for order creation
	 */

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<OrderDetails> createuser(@Valid @RequestBody OrderDetails orderDetails) {

		OrderDetails modelSaved = orderService.save(orderDetails);

		return new ResponseEntity<>(modelSaved, HttpStatus.CREATED);
	}
	
	/*
	 * PUT operation for order update
	 */
	
	@PutMapping(path = "/{orderId}", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Object> updateUser(@PathVariable int orderId, @Valid @RequestBody OrderDetails orderDetails) {
	 
	
		
		return null;
	}
	
}









