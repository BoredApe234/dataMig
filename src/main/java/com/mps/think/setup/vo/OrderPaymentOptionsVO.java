package com.mps.think.setup.vo;

import com.mps.think.setup.model.Publisher;

public class OrderPaymentOptionsVO {

	private Integer id;

//	private Integer publisherId;

	private String proformaOptions;

	private String creditCardProcessing;

	private String installmentBilling;

	private Boolean prepaymentRequired;

	private Boolean autoReplace;

	private Boolean chargeShipping;

	private Boolean taxable;
	
	private Boolean isActive;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProformaOptions() {
		return proformaOptions;
	}

	public void setProformaOptions(String proformaOptions) {
		this.proformaOptions = proformaOptions;
	}

	public String getCreditCardProcessing() {
		return creditCardProcessing;
	}

	public void setCreditCardProcessing(String creditCardProcessing) {
		this.creditCardProcessing = creditCardProcessing;
	}

	public String getInstallmentBilling() {
		return installmentBilling;
	}

	public void setInstallmentBilling(String installmentBilling) {
		this.installmentBilling = installmentBilling;
	}

	public Boolean getPrepaymentRequired() {
		return prepaymentRequired;
	}

	public void setPrepaymentRequired(Boolean prepaymentRequired) {
		this.prepaymentRequired = prepaymentRequired;
	}

	public Boolean getAutoReplace() {
		return autoReplace;
	}

	public void setAutoReplace(Boolean autoReplace) {
		this.autoReplace = autoReplace;
	}

	public Boolean getChargeShipping() {
		return chargeShipping;
	}

	public void setChargeShipping(Boolean chargeShipping) {
		this.chargeShipping = chargeShipping;
	}

	public Boolean getTaxable() {
		return taxable;
	}

	public void setTaxable(Boolean taxable) {
		this.taxable = taxable;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	
}
