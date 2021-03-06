package com.edureka.orderms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edureka.orderms.model.OrderDetails;

@Repository
public interface OrderRepository extends JpaRepository<OrderDetails, Long> {

	List<OrderDetails> findAll();
}
