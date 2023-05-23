package com.mps.think.setup.vo;

import com.mps.think.setup.model.Publisher;

public class PaymentThresholdDefVO {

	private Integer id;

	private String paymentThresholdCode;

	private String paymentThresholdDescription;
	
	private Publisher publisher;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPaymentThresholdCode() {
		return paymentThresholdCode;
	}

	public void setPaymentThresholdCode(String paymentThresholdCode) {
		this.paymentThresholdCode = paymentThresholdCode;
	}

	public String getPaymentThresholdDescription() {
		return paymentThresholdDescription;
	}

	public void setPaymentThresholdDescription(String paymentThresholdDescription) {
		this.paymentThresholdDescription = paymentThresholdDescription;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "PaymentThresholdDefVO [id=" + id + ", paymentThresholdCode=" + paymentThresholdCode
				+ ", paymentThresholdDescription=" + paymentThresholdDescription + ", publisher=" + publisher + "]";
	}

	
}
