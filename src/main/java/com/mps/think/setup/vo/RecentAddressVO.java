package com.mps.think.setup.vo;

public class RecentAddressVO {

	private OrderAddressMappingVO orderAddressMapping;
	
	private String customerName;

	public OrderAddressMappingVO getOrderAddressMapping() {
		return orderAddressMapping;
	}

	public void setOrderAddressMapping(OrderAddressMappingVO orderAddressMapping) {
		this.orderAddressMapping = orderAddressMapping;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
}
