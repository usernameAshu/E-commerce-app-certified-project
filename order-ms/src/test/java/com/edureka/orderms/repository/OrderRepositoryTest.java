package com.edureka.orderms.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.edureka.orderms.model.OrderDetails;

@RunWith(SpringRunner.class)
@DataJpaTest
public class OrderRepositoryTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private OrderRepository orderRepository ;

	
	@Test
	public void testgetOrders() {
		
		OrderDetails object1 = new OrderDetails();
		object1.setCustomerid(100L);
		object1.setStatus("SHIPPED");
		object1.setOrderDate(new Date("24-JAN-2019")); 

		OrderDetails object2 = new OrderDetails();
		object2.setCustomerid(200L);
		object2.setStatus("CONFIRMED");
		object2.setOrderDate(new Date("25-JAN-2019")); 
		
		entityManager.persist(object1);
		entityManager.persist(object2);
		
		Iterable<OrderDetails> iterable = orderRepository.findAll();
		List<OrderDetails> arrayList = new ArrayList<>();
		
		for(OrderDetails orders : iterable)
			{
			arrayList.add(orders);
			System.out.println(orders);
			}
		
		assertThat(arrayList.size()).isEqualTo(8);
	
	}
	
	@Test
	public void testgetOrderById() {
		
		OrderDetails object1 = new OrderDetails();
		object1.setCustomerid(100L);
		object1.setStatus("SHIPPED");
		object1.setOrderDate(new Date("24-JAN-2019"));
		
		 OrderDetails savedinDB = entityManager.persist(object1);
		 OrderDetails getfromDB = orderRepository.findById(object1.getOrderId()).get();
		 
		 assertThat(getfromDB).isEqualTo(savedinDB);
		
		
	}
	
	@Test
	public void testcreateOrder() {
		OrderDetails object1 = new OrderDetails();
		object1.setCustomerid(100L);
		object1.setStatus("SHIPPED");
		object1.setOrderDate(new Date("24-JAN-2019"));
		
		 OrderDetails savedinDB = entityManager.persist(object1);
		 OrderDetails getfromDB = orderRepository.findById(object1.getOrderId()).get();
		 
		 assertThat(getfromDB).isEqualTo(savedinDB);
	}
	
	@Test
	public void testupdateOrder() {
		OrderDetails object1 = new OrderDetails();
		object1.setCustomerid(100L);
		object1.setStatus("SHIPPED");
		object1.setOrderDate(new Date("24-JAN-2019"));
		
		 OrderDetails savedinDB = entityManager.persist(object1);
		 OrderDetails getfromDB =  orderRepository.findById(object1.getOrderId()).get();
		 getfromDB.setStatus("DELIVERED");
		 
		 assertThat(getfromDB.getStatus()).isEqualTo("DELIVERED");
	}
	
	@Test
	public void testdeleteOrderById() {
		OrderDetails object1 = new OrderDetails();
		object1.setCustomerid(100L);
		object1.setStatus("SHIPPED");
		object1.setOrderDate(new Date("24-JAN-2019")); 

		OrderDetails object2 = new OrderDetails();
		object2.setCustomerid(200L);
		object2.setStatus("CONFIRMED");
		object2.setOrderDate(new Date("25-JAN-2019")); 
		
		OrderDetails persist = entityManager.persist(object1);
		entityManager.persist(object2);
		
		orderRepository.delete(persist);
		
		Iterable<OrderDetails> iterable = orderRepository.findAll();
		List<OrderDetails> arrayList = new ArrayList<>();
		
		for(OrderDetails orders : iterable)
			{
			arrayList.add(orders);
			System.out.println(orders);
			}
		
		assertThat(arrayList.size()).isEqualTo(7);
	}
}