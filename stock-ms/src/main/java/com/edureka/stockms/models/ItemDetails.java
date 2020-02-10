package com.edureka.stockms.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item_details")
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

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public int getPhysicalStock() {
		return physicalStock;
	}

	public void setPhysicalStock(int physicalStock) {
		this.physicalStock = physicalStock;
	}

	public int getAvailableStock() {
		return availableStock;
	}

	public void setAvailableStock(int availableStock) {
		this.availableStock = availableStock;
	}

	public int getReservedStock() {
		return reservedStock;
	}

	public void setReservedStock(int reservedStock) {
		this.reservedStock = reservedStock;
	}

}
