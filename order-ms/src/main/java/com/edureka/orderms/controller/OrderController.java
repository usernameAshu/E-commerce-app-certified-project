package com.edureka.orderms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edureka.orderms.model.OrderDetails;
import com.edureka.orderms.service.OrderServiceInterface;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {

	@Autowired
	private OrderServiceInterface orderService;

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

	@GetMapping
	public ResponseEntity<List<OrderDetails>> getOrders(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "20") int limit) {
		LOGGER.info("Getting All Customers from Service class");
		return orderService.getOrders();
	}

	@GetMapping(path = "/{orderId}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<OrderDetails> getOrderById(@PathVariable Long orderId) {
		LOGGER.info("Getting  Customer from Service class");
		return orderService.getOrderById(orderId);
	}

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<OrderDetails> createOrder(@RequestBody OrderDetails orderDetails) {
		LOGGER.info("Creating Customer object in Service class");
		return orderService.createOrder(orderDetails);
	}

	@PutMapping(path = "/{orderId}", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Object> updateOrder(@PathVariable Long orderId, @RequestBody OrderDetails orderDetails) {
		LOGGER.info("Updating Customer object in service class");
		return orderService.updateOrder(orderId, orderDetails);
	}

	@DeleteMapping(path = "/{orderId}")
	public ResponseEntity<String> deleteOrderById(@PathVariable Long orderId) {
		LOGGER.info("Deleting Customer object in service class");
		return orderService.deleteOrderById(orderId);
	}

}