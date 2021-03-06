package com.edureka.orderms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edureka.orderms.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
