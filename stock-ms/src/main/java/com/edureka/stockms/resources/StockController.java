package com.edureka.stockms.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edureka.stockms.models.ItemDetails;
import com.edureka.stockms.service.StockServiceInterface;

@RestController
@RequestMapping(path = "/stocks")
public class StockController {

	@Autowired
	private StockServiceInterface serviceInterface;

	private static final Logger LOGGER = LoggerFactory.getLogger(StockController.class);
	
	@GetMapping
	public ResponseEntity<List<ItemDetails>> getAllStocks() {
		LOGGER.info("Fetching Stocks from service layer");
		return serviceInterface.getAllStocks();

	}
	
	@GetMapping(path= "/{itemId}"  ,
			produces = {MediaType.APPLICATION_JSON_VALUE , 
						MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<ItemDetails> getStockForItem(@PathVariable Long itemId) {
		LOGGER.info("Fetching Stocks from service layer for item level");
		return serviceInterface.getStockForItem(itemId);
	}
	
	/*
	 * @GetMapping(path= "/{itemId}" , produces = {MediaType.APPLICATION_JSON_VALUE
	 * , MediaType.APPLICATION_XML_VALUE}) public ResponseEntity<Integer>
	 * getAvailStock(@PathVariable Long itemId) { return
	 * serviceInterface.getAvailStock(itemId); }
	 */

}
