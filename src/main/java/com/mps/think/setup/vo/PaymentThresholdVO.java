package com.mps.think.setup.vo;

import com.mps.think.setup.model.PaymentThresholdDef;
import com.mps.think.setup.model.Publisher;

public class PaymentThresholdVO {

	private Integer paymentThresholdId;

	private Integer partialThreshold;

	private Integer underThreshold;

	private Integer overThreshold;

	private Integer refundThreshold;

	private Integer maxUnderpaymentForFull;

	private Integer maxUnderpaymentForPartial;

	private Integer maxOverpaymentForFull;

	private Integer maxOverpaymentForRefund;
	
	private Publisher publisher;
	
	private String overpaymentAction;

	private String underpaymentAction;

	private boolean overpaymentOverrides;

	private boolean underpaymentOverrides;
	
	private PaymentThresholdDef paymentThresholdDef;

	public Integer getPaymentThresholdId() {
		return paymentThresholdId;
	}

	public void setPaymentThresholdId(Integer paymentThresholdId) {
		this.paymentThresholdId = paymentThresholdId;
	}

	public Integer getPartialThreshold() {
		return partialThreshold;
	}

	public void setPartialThreshold(Integer partialThreshold) {
		this.partialThreshold = partialThreshold;
	}

	public Integer getUnderThreshold() {
		return underThreshold;
	}

	public void setUnderThreshold(Integer underThreshold) {
		this.underThreshold = underThreshold;
	}

	public Integer getOverThreshold() {
		return overThreshold;
	}

	public void setOverThreshold(Integer overThreshold) {
		this.overThreshold = overThreshold;
	}

	public Integer getRefundThreshold() {
		return refundThreshold;
	}

	public void setRefundThreshold(Integer refundThreshold) {
		this.refundThreshold = refundThreshold;
	}

	public Integer getMaxUnderpaymentForFull() {
		return maxUnderpaymentForFull;
	}

	public void setMaxUnderpaymentForFull(Integer maxUnderpaymentForFull) {
		this.maxUnderpaymentForFull = maxUnderpaymentForFull;
	}

	public Integer getMaxUnderpaymentForPartial() {
		return maxUnderpaymentForPartial;
	}

	public void setMaxUnderpaymentForPartial(Integer maxUnderpaymentForPartial) {
		this.maxUnderpaymentForPartial = maxUnderpaymentForPartial;
	}

	public Integer getMaxOverpaymentForFull() {
		return maxOverpaymentForFull;
	}

	public void setMaxOverpaymentForFull(Integer maxOverpaymentForFull) {
		this.maxOverpaymentForFull = maxOverpaymentForFull;
	}

	public Integer getMaxOverpaymentForRefund() {
		return maxOverpaymentForRefund;
	}

	public void setMaxOverpaymentForRefund(Integer maxOverpaymentForRefund) {
		this.maxOverpaymentForRefund = maxOverpaymentForRefund;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public String getOverpaymentAction() {
		return overpaymentAction;
	}

	public void setOverpaymentAction(String overpaymentAction) {
		this.overpaymentAction = overpaymentAction;
	}

	public String getUnderpaymentAction() {
		return underpaymentAction;
	}

	public void setUnderpaymentAction(String underpaymentAction) {
		this.underpaymentAction = underpaymentAction;
	}

	public boolean isOverpaymentOverrides() {
		return overpaymentOverrides;
	}

	public void setOverpaymentOverrides(boolean overpaymentOverrides) {
		this.overpaymentOverrides = overpaymentOverrides;
	}

	public boolean isUnderpaymentOverrides() {
		return underpaymentOverrides;
	}

	public void setUnderpaymentOverrides(boolean underpaymentOverrides) {
		this.underpaymentOverrides = underpaymentOverrides;
	}

	public PaymentThresholdDef getPaymentThresholdDef() {
		return paymentThresholdDef;
	}

	public void setPaymentThresholdDef(PaymentThresholdDef paymentThresholdDef) {
		this.paymentThresholdDef = paymentThresholdDef;
	}


	
}
