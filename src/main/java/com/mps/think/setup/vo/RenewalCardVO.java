package com.mps.think.setup.vo;


import com.mps.think.setup.model.DiscountCardKeyInfo;
import com.mps.think.setup.model.OrderClass;
import com.mps.think.setup.model.OrderCodes;
import com.mps.think.setup.model.OrderCodesSuper;
import com.mps.think.setup.model.Publisher;
import com.mps.think.setup.model.RateCards;
import com.mps.think.setup.model.SourceCode;
import com.mps.think.setup.model.SubscriptionDefKeyInfo;

public class RenewalCardVO {

	private Integer renewalCardId;
	
	private String description;
	
	private String renewal_card;
	
	private String effortFrom;
	
	private String effortTo;
	
	private String offersdescription;

	private DiscountCardKeyInfo discountClassId;
	
	private OrderCodesSuper orderCodeId;
	
	private  String pkgDefId;
	
	private RateCards rateClassId;
	
	private SourceCode sourceCodeId;
	
	private SubscriptionDefKeyInfo subscriptionDefId;
	
	private OrderClass orderClassId;
	
	private Publisher pubId;

	public Integer getRenewalCardId() {
		return renewalCardId;
	}

	public void setRenewalCardId(Integer renewalCardId) {
		this.renewalCardId = renewalCardId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRenewal_card() {
		return renewal_card;
	}

	public void setRenewal_card(String renewal_card) {
		this.renewal_card = renewal_card;
	}

	public String getEffortFrom() {
		return effortFrom;
	}

	public void setEffortFrom(String effortFrom) {
		this.effortFrom = effortFrom;
	}

	public String getEffortTo() {
		return effortTo;
	}

	public void setEffortTo(String effortTo) {
		this.effortTo = effortTo;
	}

	public String getOffersdescription() {
		return offersdescription;
	}

	public void setOffersdescription(String offersdescription) {
		this.offersdescription = offersdescription;
	}

	public DiscountCardKeyInfo getDiscountClassId() {
		return discountClassId;
	}

	public void setDiscountClassId(DiscountCardKeyInfo discountClassId) {
		this.discountClassId = discountClassId;
	}

	public String getPkgDefId() {
		return pkgDefId;
	}

	public void setPkgDefId(String pkgDefId) {
		this.pkgDefId = pkgDefId;
	}

	public RateCards getRateClassId() {
		return rateClassId;
	}

	public void setRateClassId(RateCards rateClassId) {
		this.rateClassId = rateClassId;
	}

	public SourceCode getSourceCodeId() {
		return sourceCodeId;
	}

	public void setSourceCodeId(SourceCode sourceCodeId) {
		this.sourceCodeId = sourceCodeId;
	}

	public SubscriptionDefKeyInfo getSubscriptionDefId() {
		return subscriptionDefId;
	}

	public void setSubscriptionDefId(SubscriptionDefKeyInfo subscriptionDefId) {
		this.subscriptionDefId = subscriptionDefId;
	}

	public OrderClass getOrderClassId() {
		return orderClassId;
	}

	public void setOrderClassId(OrderClass orderClassId) {
		this.orderClassId = orderClassId;
	}

	public Publisher getPubId() {
		return pubId;
	}

	public void setPubId(Publisher pubId) {
		this.pubId = pubId;
	}

	public OrderCodesSuper getOrderCodeId() {
		return orderCodeId;
	}

	public void setOrderCodeId(OrderCodesSuper orderCodeId) {
		this.orderCodeId = orderCodeId;
	}


	
}
