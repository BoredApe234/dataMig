package com.mps.think.setup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "inventory_bulk_totals")
@Entity
public class InventoryBulkTotals extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2312654077087406991L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "on_ventory_order")
	private Integer onVentoryOrder;
	
	@Column(name = "on_ventory_back_order")
	private Integer onVentoryBackOrder;
	
	@Column(name = "bulk_in_stock")
	private Integer bulkInStock;
	
	@Column(name = "inventory_in_transfer")
	private Integer inventoryInTransfer;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOnVentoryOrder() {
		return onVentoryOrder;
	}

	public void setOnVentoryOrder(Integer onVentoryOrder) {
		this.onVentoryOrder = onVentoryOrder;
	}

	public Integer getOnVentoryBackOrder() {
		return onVentoryBackOrder;
	}

	public void setOnVentoryBackOrder(Integer onVentoryBackOrder) {
		this.onVentoryBackOrder = onVentoryBackOrder;
	}

	public Integer getBulkInStock() {
		return bulkInStock;
	}

	public void setBulkInStock(Integer bulkInStock) {
		this.bulkInStock = bulkInStock;
	}

	public Integer getInventoryInTransfer() {
		return inventoryInTransfer;
	}

	public void setInventoryInTransfer(Integer inventoryInTransfer) {
		this.inventoryInTransfer = inventoryInTransfer;
	}
	
}
