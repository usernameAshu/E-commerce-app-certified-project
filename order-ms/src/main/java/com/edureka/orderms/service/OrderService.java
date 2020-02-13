package com.edureka.orderms.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.edureka.orderms.model.OrderDetails;

public interface OrderService {

	public ResponseEntity<List<OrderDetails>> getOrders() ;
	public ResponseEntity<OrderDetails> getOrderById(Long orderId) ;
	public ResponseEntity<OrderDetails> createOrder(OrderDetails orderDetails);
	public ResponseEntity<Object> updateOrder(Long orderId, OrderDetails orderDetails);
	public ResponseEntity<String> deleteOrderById(Long orderId);

}
