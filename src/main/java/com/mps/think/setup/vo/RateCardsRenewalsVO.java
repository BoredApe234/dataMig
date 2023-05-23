package com.mps.think.setup.vo;

import java.util.Date;



import com.mps.think.setup.model.RateCards;
import com.mps.think.setup.vo.EnumModelVO.Currency;

public class RateCardsRenewalsVO {
	
    private Integer id;
	private RateCards renewalId;
	private Float basicPrice;
	private Integer noOfItem;
	private Float unitPrice;
	private Currency currency;
	private Date validFrom;
	private Date validTo;
	private Integer fromQuantity;
	private Integer toQuantity;
	private String validForRegions;
	private Date renewalExpiryDate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public RateCards getRenewalId() {
		return renewalId;
	}
	public void setRenewalId(RateCards renewalId) {
		this.renewalId = renewalId;
	}
	public Float getBasicPrice() {
		return basicPrice;
	}
	public void setBasicPrice(Float basicPrice) {
		this.basicPrice = basicPrice;
	}
	public Integer getNoOfItem() {
		return noOfItem;
	}
	public void setNoOfItem(Integer noOfItem) {
		this.noOfItem = noOfItem;
	}
	public Float getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	public Date getValidFrom() {
		return validFrom;
	}
	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}
	public Date getValidTo() {
		return validTo;
	}
	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}
	public Integer getFromQuantity() {
		return fromQuantity;
	}
	public void setFromQuantity(Integer fromQuantity) {
		this.fromQuantity = fromQuantity;
	}
	public Integer getToQuantity() {
		return toQuantity;
	}
	public void setToQuantity(Integer toQuantity) {
		this.toQuantity = toQuantity;
	}
	public String getValidForRegions() {
		return validForRegions;
	}
	public void setValidForRegions(String validForRegions) {
		this.validForRegions = validForRegions;
	}
	public Date getRenewalExpiryDate() {
		return renewalExpiryDate;
	}
	public void setRenewalExpiryDate(Date renewalExpiryDate) {
		this.renewalExpiryDate = renewalExpiryDate;
	}

	
	

}
