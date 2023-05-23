package com.mps.think.setup.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.mps.think.setup.vo.EnumModelVO.PaymentStatus;

@Table(name = "payment_breakdown")
@Entity
public class PaymentBreakdown extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6473825965752239703L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "currency_type")
	private String currencyType;
	
	@ManyToOne
	@JoinColumn(name = "rate_card_id", referencedColumnName = "rcId")
	private RateCards rateCard;
	
	@Column(name = "effective_date")
	private Date effectiveDate;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "payment_status")
	private PaymentStatus paymentStatus;
	
	@Column(name = "term")
	private String term;
	
	@Column(name = "base_amount")
	private BigDecimal baseAmount;
	
	@Column(name = "currency")
	private String currency;
	
	@Column(name = "discount")
	private BigDecimal discount;
	
	@Column(name = "tax")
	private BigDecimal tax;
	
	@Column(name = "gross_amount")
	private BigDecimal grossAmount;
	
	@Column(name = "commission")
	private BigDecimal commission;

	@Column(name = "shipping_charge")
	private BigDecimal shippingCharge;
	
	@Column(name = "net_amount")
	private BigDecimal netAmount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}

	public RateCards getRateCard() {
		return rateCard;
	}

	public void setRateCard(RateCards rateCard) {
		this.rateCard = rateCard;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public BigDecimal getBaseAmount() {
		return baseAmount;
	}

	public void setBaseAmount(BigDecimal baseAmount) {
		this.baseAmount = baseAmount;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public BigDecimal getGrossAmount() {
		return grossAmount;
	}

	public void setGrossAmount(BigDecimal grossAmount) {
		this.grossAmount = grossAmount;
	}

	public BigDecimal getCommission() {
		return commission;
	}

	public void setCommission(BigDecimal commission) {
		this.commission = commission;
	}

	public BigDecimal getShippingCharge() {
		return shippingCharge;
	}

	public void setShippingCharge(BigDecimal shippingCharge) {
		this.shippingCharge = shippingCharge;
	}

	public BigDecimal getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(BigDecimal netAmount) {
		this.netAmount = netAmount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	

}
