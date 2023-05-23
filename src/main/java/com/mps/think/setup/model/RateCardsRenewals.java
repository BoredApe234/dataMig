package com.mps.think.setup.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.mps.think.setup.vo.EnumModelVO.Currency;

@Table(name = "rateCardRenewals")
@Entity
public class RateCardsRenewals extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "rc_id", referencedColumnName = "rcId")
	private RateCards renewalId;
	
	@Column(name = "basicPrice")
	private Float basicPrice;
	
	@Column(name = "noofItem")
	private Integer noOfItem;
	
	@Column(name = "unitPrice")
	private Float unitPrice;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "currency")
	private Currency currency;
	
	@Column(name = "validfrom")
	private Date validFrom;
	
	@Column(name = "validto")
	private Date validTo;
	
	@Column(name = "fromQuantity")
	private Integer fromQuantity;
	
	@Column(name = "toQuantity")
	private Integer toQuantity;
	
	@Column(name = "validForRegions")
	private String validForRegions;
	
	@Column(name = "renewalExpiryDate")
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
