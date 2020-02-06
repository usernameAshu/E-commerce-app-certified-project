package com.edureka.orderms.controller;

import java.util.List;

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

 /*
  * Using repo in place of service, will change after adding methods in the
  * service layer
  */

 @Autowired
 private OrderServiceInterface orderService;

 /*
  * READ operation for fetching ALL orders
  */

 @GetMapping
 public ResponseEntity < List < OrderDetails >> getOrders(@RequestParam(value = "page", defaultValue = "1") int page,
  @RequestParam(value = "limit", defaultValue = "20") int limit) {

  return orderService.getOrders();
 }

 /*
  * READ by order id
  */
 @GetMapping(path = "/{orderId}", produces = {
  MediaType.APPLICATION_JSON_VALUE,
  MediaType.APPLICATION_XML_VALUE
 })
 public ResponseEntity < OrderDetails > getOrderById(@PathVariable Long orderId) {

  return orderService.getOrder(orderId);
 }

 /*
  * POST operation for order creation
  */

 @PostMapping(consumes = {
  MediaType.APPLICATION_JSON_VALUE,
  MediaType.APPLICATION_XML_VALUE
 }, produces = {
  MediaType.APPLICATION_JSON_VALUE,
  MediaType.APPLICATION_XML_VALUE
 })
 public ResponseEntity < OrderDetails > createOrder(@RequestBody OrderDetails orderDetails) {

  return orderService.createOrder(orderDetails);
 }

 /*
  * PUT operation for order update
  */

 @PutMapping(path = "/{orderId}", consumes = {
  MediaType.APPLICATION_JSON_VALUE,
  MediaType.APPLICATION_XML_VALUE
 }, produces = {
  MediaType.APPLICATION_JSON_VALUE,
  MediaType.APPLICATION_XML_VALUE
 })
 public ResponseEntity < Object > updateOrder(@PathVariable Long orderId, @RequestBody OrderDetails orderDetails) {

  return orderService.updateOrder(orderId, orderDetails);
 }

 /*
  * DELETE operation for Order
  */

 @DeleteMapping(path = "/{orderId}")
 public ResponseEntity < String > deleteOrderById(@PathVariable Long orderId) {
  return orderService.deleteOrder(orderId);
 }

}