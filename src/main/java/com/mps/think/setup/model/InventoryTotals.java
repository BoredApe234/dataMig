package com.mps.think.setup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "inventory_totals")
@Entity
public class InventoryTotals extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3627519747257680571L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "order_not_shipped")
	private Integer orderNotShipped;
	
	@Column(name = "customer_back_orders")
	private Integer customerBackOrders;
	
	@Column(name = "in_stock")
	private Integer inStock;
	
	@Column(name = "on_vendor_order")
	private Integer onVendorOrder;
	
	@Column(name = "on_vendor_back_order")
	private Integer onVendorBackOrder;
	
	@Column(name = "adjustments")
	private Integer adjustments;
	
	@Column(name = "total_units_available")
	private Integer totalUnitsAvailable;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

}
