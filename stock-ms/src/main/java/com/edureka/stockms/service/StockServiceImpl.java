package com.edureka.stockms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.edureka.stockms.models.ItemDetails;
import com.edureka.stockms.repository.StockRepository;

@Service
public class StockServiceImpl implements StockService {

	@Autowired
	private StockRepository stockRepository;

	public ResponseEntity<List<ItemDetails>> getAllStocks() {

		return new ResponseEntity<>(stockRepository.findAll(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ItemDetails> getStockForItem(Long itemId) {

		if (stockRepository.findById(itemId).isPresent())
			return new ResponseEntity<>(stockRepository.findById(itemId).get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

	@Override
	public ResponseEntity<Integer> getAvailStock(Long itemId) {

		int availStock;

		if (stockRepository.findById(itemId).isPresent()) {

			availStock = stockRepository.findById(itemId).get().getAvailableStock();
			return new ResponseEntity<>(availStock, HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
