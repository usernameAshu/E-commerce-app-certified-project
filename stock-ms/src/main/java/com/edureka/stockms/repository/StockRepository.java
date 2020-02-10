package com.edureka.stockms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edureka.stockms.models.ItemDetails;

public interface StockRepository extends JpaRepository<ItemDetails, Long> {

}
