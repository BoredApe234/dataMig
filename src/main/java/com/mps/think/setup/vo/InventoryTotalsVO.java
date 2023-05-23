package com.mps.think.setup.vo;

public class InventoryTotalsVO {
	
	private Integer id;
	
	private Integer orderNotShipped;
	
	private Integer customerBackOrders;
	
	private Integer inStock;
	
	private Integer onVendorOrder;
	
	private Integer onVendorBackOrder;
	
	private Integer adjustments;
	
	private Integer totalUnitsAvailable;

	public Integer getOrderNotShipped() {
		return orderNotShipped;
	}

	public void setOrderNotShipped(Integer orderNotShipped) {
		this.orderNotShipped = orderNotShipped;
	}

	public Integer getCustomerBackOrders() {
		return customerBackOrders;
	}

	public void setCustomerBackOrders(Integer customerBackOrders) {
		this.customerBackOrders = customerBackOrders;
	}

	public Integer getInStock() {
		return inStock;
	}

	public void setInStock(Integer inStock) {
		this.inStock = inStock;
	}

	public Integer getOnVendorOrder() {
		return onVendorOrder;
	}

	public void setOnVendorOrder(Integer onVendorOrder) {
		this.onVendorOrder = onVendorOrder;
	}

	public Integer getOnVendorBackOrder() {
		return onVendorBackOrder;
	}

	public void setOnVendorBackOrder(Integer onVendorBackOrder) {
		this.onVendorBackOrder = onVendorBackOrder;
	}

	public Integer getAdjustments() {
		return adjustments;
	}

	public void setAdjustments(Integer adjustments) {
		this.adjustments = adjustments;
	}

	public Integer getTotalUnitsAvailable() {
		return totalUnitsAvailable;
	}

	public void setTotalUnitsAvailable(Integer totalUnitsAvailable) {
		this.totalUnitsAvailable = totalUnitsAvailable;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
