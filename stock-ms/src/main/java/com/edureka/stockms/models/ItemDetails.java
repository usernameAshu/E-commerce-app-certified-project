package com.edureka.stockms.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "item_details")
@Data
@NoArgsConstructor
public class ItemDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_id")
	private Long itemId;

	@Column(name = "item_name")
	private String itemName;

	@Column(name = "item_desc")
	private String itemDesc;

	@Column(name = "physical_stock")
	private int physicalStock;

	@Column(name = "available_stock")
	private int availableStock;

	@Column(name = "reserved_stock")
	private int reservedStock;

	
}
