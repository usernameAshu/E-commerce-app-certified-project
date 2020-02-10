package com.edureka.stockms.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.edureka.stockms.models.ItemDetails;

public interface StockServiceInterface {

	public ResponseEntity<List<ItemDetails>> getAllStocks() ;
	public ResponseEntity<ItemDetails> getStockForItem(Long itemId) ;
	public ResponseEntity<Integer> getAvailStock(Long itemId) ;
	
}
