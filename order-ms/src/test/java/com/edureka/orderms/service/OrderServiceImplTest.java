
package com.edureka.orderms.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.edureka.orderms.model.OrderDetails;
import com.edureka.orderms.repository.OrderRepository;

@RunWith(SpringRunner.class)

@SpringBootTest
public class OrderServiceImplTest {

	@Autowired
	private OrderService orderServiceInterface;

	@MockBean
	private OrderRepository orderRepository;

	@Test
	public void testGetOrders() {

		OrderDetails object1 = new OrderDetails();
		object1.setOrderId(1L);
		object1.setCustomerid(100L);
		object1.setStatus("SHIPPED");
		object1.setOrderDate(new Date("24-JAN-2019"));

		OrderDetails object2 = new OrderDetails();
		object1.setOrderId(2L);
		object1.setCustomerid(200L);
		object1.setStatus("CONFIRMED");
		object1.setOrderDate(new Date("25-JAN-2019"));

		List<OrderDetails> orderList = new ArrayList<>();
		orderList.add(object1);
		orderList.add(object2);

		Mockito.when(orderRepository.findAll()).thenReturn(orderList);

		assertThat(orderServiceInterface.getOrders())
				.isEqualTo(new ResponseEntity<List<OrderDetails>>(orderList, HttpStatus.OK));

	}

	@Test
	public void testgetOrderById() {

		OrderDetails object1 = new OrderDetails();
		object1.setOrderId(1L);
		object1.setCustomerid(100L);
		object1.setStatus("SHIPPED");
		object1.setOrderDate(new Date("24-JAN-2019"));

		when(orderRepository.findById(1L)).thenReturn(Optional.of(object1));
		assertThat(orderServiceInterface.getOrderById(object1.getOrderId()))
				.isEqualTo(new ResponseEntity<OrderDetails>(object1, HttpStatus.OK));
	}

	@SuppressWarnings("deprecation")

	@Test
	public void testCreateOrder() {

		OrderDetails object1 = new OrderDetails();
		object1.setOrderId(1L);
		object1.setCustomerid(100L);
		object1.setStatus("SHIPPED");
		object1.setOrderDate(new Date("24-JAN-2019"));

		Mockito.when(orderRepository.save(object1)).thenReturn(object1);

		assertThat(orderServiceInterface.createOrder(object1))
				.isEqualTo(new ResponseEntity<OrderDetails>(object1, HttpStatus.CREATED));
	}

	@Test
	public void testUpdateOrder() {

		OrderDetails object1 = new OrderDetails();
		object1.setOrderId(1L);
		object1.setCustomerid(100L);
		object1.setStatus("SHIPPED");
		object1.setOrderDate(new Date("24-JAN-2019"));

		when(orderRepository.findById(1L)).thenReturn(Optional.of(object1));
		object1.setStatus("DELIVERED");
		when(orderRepository.save(object1)).thenReturn(object1);
		assertThat(orderServiceInterface.updateOrder(1L, object1))
				.isEqualTo(new ResponseEntity<OrderDetails>(object1, HttpStatus.OK));
	}

	@Test
	public void testDeleteOrderById() {

		OrderDetails object1 = new OrderDetails();
		object1.setOrderId(1L);
		object1.setCustomerid(100L);
		object1.setStatus("SHIPPED");
		object1.setOrderDate(new Date("24-JAN-2019"));

		// when(orderRepository.findById(1L)).thenReturn(Optional.of(object1));
		when(orderRepository.existsById(1L)).thenReturn(false);
		assertFalse(orderRepository.existsById(object1.getOrderId()));

	}

}
