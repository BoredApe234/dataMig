package com.mps.think.setup.vo;

import com.mps.think.setup.model.Publisher;
import com.mps.think.setup.vo.EnumModelVO.CVVValues;
import com.mps.think.setup.vo.EnumModelVO.RealiseCashWhen;

public class PaymentTypeVO {

	private Integer id;
	
	private String paymentType;
	
	private String description;
	
	private String paymentForm;
	
	private String realiseCashWhen; // dropdown
	
	private Boolean useAsDefault;
	
	private String creditCardType;
	
	private String cvv; // dropdown
	
	private Publisher publisher;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPaymentForm() {
		return paymentForm;
	}

	public void setPaymentForm(String paymentForm) {
		this.paymentForm = paymentForm;
	}

	public Boolean getUseAsDefault() {
		return useAsDefault;
	}

	public void setUseAsDefault(Boolean useAsDefault) {
		this.useAsDefault = useAsDefault;
	}

	public String getCreditCardType() {
		return creditCardType;
	}

	public void setCreditCardType(String creditCardType) {
		this.creditCardType = creditCardType;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public String getRealiseCashWhen() {
		return realiseCashWhen;
	}

	public void setRealiseCashWhen(String realiseCashWhen) {
		this.realiseCashWhen = realiseCashWhen;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

}
