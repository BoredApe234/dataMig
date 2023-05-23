package com.mps.think.setup.vo;

public class InventoryBulkTotalsVO {
	
	private Integer id;
	
	private Integer onVentoryOrder;
	
	private Integer onVentoryBackOrder;
	
	private Integer bulkInStock;
	
	private Integer inventoryInTransfer;

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
