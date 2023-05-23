package com.mps.think.setup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Table(name = "renewal_card")
@Entity
public class RenewalCard extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "renewal_card_id")
	private Integer renewalCardId;
	
	@Column(name = "description")
	private String description;
	
	@Column(name="renewal_card")
	private String renewal_card;
	
	@Column(name = "effortFrom")
	private String effortFrom;
	
	@Column(name = "effortTo")
	private String effortTo;
	
	@Column(name = "offers_description")
	private String offersdescription;

	@OneToOne
	@JoinColumn(name="discount_class_id",referencedColumnName="id")
	private DiscountCardKeyInfo discountClassId;
	
	@ManyToOne
	@JoinColumn(name="order_code_id",referencedColumnName="id")
	private OrderCodesSuper orderCodeId;
	
	@Column(name = "pkg_def_id")
	private  String pkgDefId;
	
	@ManyToOne
	@JoinColumn(name="rate_class_id",referencedColumnName="rcId")
	private RateCards rateClassId;
	
	@ManyToOne
	@JoinColumn(name="source_code_id",referencedColumnName="sourc_code_id")
	private SourceCode sourceCodeId;
	
	@ManyToOne
	@JoinColumn(name="subscription_def_id",referencedColumnName="id")
	private SubscriptionDefKeyInfo subscriptionDefId;
	
	@ManyToOne
	@JoinColumn(name="order_class_id",referencedColumnName="oc_id")
	private OrderClass orderClassId;
	
	@ManyToOne
	@JoinColumn(name="pub_id",referencedColumnName="id")
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
