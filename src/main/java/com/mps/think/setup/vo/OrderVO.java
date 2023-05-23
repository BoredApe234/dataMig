package com.mps.think.setup.vo;

import java.util.List;

import com.mps.think.setup.model.CustomerDetails;
import com.mps.think.setup.model.OrderClass;
import com.mps.think.setup.vo.EnumModelVO.OrderStatus;

public class OrderVO {
	
	private Integer orderId;
	
	private CustomerDetailsVO customerId;
	
	private OrderClassVO orderClass;
	
	private String orderType;
	
	private OrderStatus orderStatus;
	
	private OrderKeyInformationVO keyOrderInformation;
	
	private OrderItemsVO orderItemsAndTerms;
	
	private PaymentBreakdownVO paymentBreakdown;
		
	private OrderDeliveryOptionsVO deliveryAndBillingOptions;
	
	private List<OrderAddressMappingVO> orderAddresses;
	
	private OrderAuxiliaryInformationVO auxiliaryInformation;
	
	private CustomerDetailsVO otherAddressCustomer;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public CustomerDetailsVO getCustomerId() {
		return customerId;
	}

	public void setCustomerId(CustomerDetailsVO customerId) {
		this.customerId = customerId;
	}

	public OrderClassVO getOrderClass() {
		return orderClass;
	}

	public void setOrderClass(OrderClassVO orderClass) {
		this.orderClass = orderClass;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public OrderKeyInformationVO getKeyOrderInformation() {
		return keyOrderInformation;
	}

	public void setKeyOrderInformation(OrderKeyInformationVO keyOrderInformation) {
		this.keyOrderInformation = keyOrderInformation;
	}

	public OrderItemsVO getOrderItemsAndTerms() {
		return orderItemsAndTerms;
	}

	public void setOrderItemsAndTerms(OrderItemsVO orderItemsAndTerms) {
		this.orderItemsAndTerms = orderItemsAndTerms;
	}

	public PaymentBreakdownVO getPaymentBreakdown() {
		return paymentBreakdown;
	}

	public void setPaymentBreakdown(PaymentBreakdownVO paymentBreakdown) {
		this.paymentBreakdown = paymentBreakdown;
	}

	public OrderDeliveryOptionsVO getDeliveryAndBillingOptions() {
		return deliveryAndBillingOptions;
	}

	public void setDeliveryAndBillingOptions(OrderDeliveryOptionsVO deliveryAndBillingOptions) {
		this.deliveryAndBillingOptions = deliveryAndBillingOptions;
	}

	public List<OrderAddressMappingVO> getOrderAddresses() {
		return orderAddresses;
	}

	public void setOrderAddresses(List<OrderAddressMappingVO> orderAddresses) {
		this.orderAddresses = orderAddresses;
	}

	public OrderAuxiliaryInformationVO getAuxiliaryInformation() {
		return auxiliaryInformation;
	}

	public void setAuxiliaryInformation(OrderAuxiliaryInformationVO auxiliaryInformation) {
		this.auxiliaryInformation = auxiliaryInformation;
	}

	public CustomerDetailsVO getOtherAddressCustomer() {
		return otherAddressCustomer;
	}

	public void setOtherAddressCustomer(CustomerDetailsVO otherAddressCustomer) {
		this.otherAddressCustomer = otherAddressCustomer;
	}

	

}
