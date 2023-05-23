package com.mps.think.setup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="payment_threshold_def")
public class PaymentThresholdDef {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="code")
	private String paymentThresholdCode;
	
	@Column(name="description")
	private String paymentThresholdDescription;
	
	@OneToOne
	@JoinColumn(name="pub_id",referencedColumnName="id")
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
		return "PaymentThresholdDef [id=" + id + ", paymentThresholdCode=" + paymentThresholdCode
				+ ", paymentThresholdDescription=" + paymentThresholdDescription + ", publisher=" + publisher + "]";
	}
}
