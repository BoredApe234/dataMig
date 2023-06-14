package com.mps.think.setup.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_threshold_info")
public class OrderThresholdInfo extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "oc_id", referencedColumnName = "oc_id" )
	private OrderClass orderClass;
	
	@Column(name = "customer_nbr")
	private String customerNbr;
	
	@OneToOne
	@JoinColumn(name = "terms_id", referencedColumnName = "termsId" )
	private Terms terms;
	
	@Column(name = "order_nbr")
	private String orderNbr;
	
	@Column(name = "start_date")
	private Date startDate;
	
	@Column(name = "line_item")
	private Integer lineItem;
	
	@OneToOne
	@JoinColumn(name = "source_code_id", referencedColumnName = "sourc_code_id" )
	private SourceCode sourceCode;
	
	@Column(name = "order_date")
	private Date orderDate;
	
	@OneToOne
	@JoinColumn(name = "order_id", referencedColumnName = "order_id" )
	private Order order;
	
	@Column(name = "total_paid")
	private double totalPaid;
	
	@Column(name = "payment_status")
	private String paymentStatus;
	
	@Column(name = "under_payment_option")
	private String underPaymentOption;
	
	@Column(name = "expiration_original")
	private Date expirationOriginal;
	
	@Column(name = "expiration_prorated")
	private Date expirationProrated;
	
	@Column(name = "order_quantity_original")
	private Integer orderQuantityOriginal;
	
	@Column(name = "order_quantity_prorated")
	private Integer orderQuantityProrated;
	
	@Column(name = "remaining_original")
	private Integer remainingOriginal;
	
	@Column(name = "remaining_prorated")
	private Integer remainingProrated;
	
	@Column(name = "order_amnt_subs_original")
	private double orderAmntSubsOriginal;
	
	@Column(name = "order_amnt_subs_prorated")
	private double orderAmntSubsProrated;
	
	@Column(name = "order_amnt_delivery_original")
	private double orderAmntDeliveryOriginal;
	
	@Column(name = "order_amnt_delivery_prorated")
	private double orderAmntDeliveryProrated;
	
	@Column(name = "order_amnt_tax_original")
	private double orderAmntTaxOriginal;
	
	@Column(name = "order_amnt_tax_prorated")
	private double orderAmntTaxProrated;
	
	@OneToOne
	@JoinColumn(name = "pub_id", referencedColumnName = "id" )
	private Publisher publisher;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public OrderClass getOrderClass() {
		return orderClass;
	}

	public void setOrderClass(OrderClass orderClass) {
		this.orderClass = orderClass;
	}

	public String getCustomerNbr() {
		return customerNbr;
	}

	public void setCustomerNbr(String customerNbr) {
		this.customerNbr = customerNbr;
	}

	public Terms getTerms() {
		return terms;
	}

	public void setTerms(Terms terms) {
		this.terms = terms;
	}

	public String getOrderNbr() {
		return orderNbr;
	}

	public void setOrderNbr(String orderNbr) {
		this.orderNbr = orderNbr;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Integer getLineItem() {
		return lineItem;
	}

	public void setLineItem(Integer lineItem) {
		this.lineItem = lineItem;
	}

	public SourceCode getSourceCode() {
		return sourceCode;
	}

	public void setSourceCode(SourceCode sourceCode) {
		this.sourceCode = sourceCode;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public double getTotalPaid() {
		return totalPaid;
	}

	public void setTotalPaid(double totalPaid) {
		this.totalPaid = totalPaid;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getUnderPaymentOption() {
		return underPaymentOption;
	}

	public void setUnderPaymentOption(String underPaymentOption) {
		this.underPaymentOption = underPaymentOption;
	}

	public Date getExpirationOriginal() {
		return expirationOriginal;
	}

	public void setExpirationOriginal(Date expirationOriginal) {
		this.expirationOriginal = expirationOriginal;
	}

	public Date getExpirationProrated() {
		return expirationProrated;
	}

	public void setExpirationProrated(Date expirationProrated) {
		this.expirationProrated = expirationProrated;
	}

	public Integer getOrderQuantityOriginal() {
		return orderQuantityOriginal;
	}

	public void setOrderQuantityOriginal(Integer orderQuantityOriginal) {
		this.orderQuantityOriginal = orderQuantityOriginal;
	}

	public Integer getOrderQuantityProrated() {
		return orderQuantityProrated;
	}

	public void setOrderQuantityProrated(Integer orderQuantityProrated) {
		this.orderQuantityProrated = orderQuantityProrated;
	}

	public Integer getRemainingOriginal() {
		return remainingOriginal;
	}

	public void setRemainingOriginal(Integer remainingOriginal) {
		this.remainingOriginal = remainingOriginal;
	}

	public Integer getRemainingProrated() {
		return remainingProrated;
	}

	public void setRemainingProrated(Integer remainingProrated) {
		this.remainingProrated = remainingProrated;
	}

	public double getOrderAmntSubsOriginal() {
		return orderAmntSubsOriginal;
	}

	public void setOrderAmntSubsOriginal(double orderAmntSubsOriginal) {
		this.orderAmntSubsOriginal = orderAmntSubsOriginal;
	}

	public double getOrderAmntSubsProrated() {
		return orderAmntSubsProrated;
	}

	public void setOrderAmntSubsProrated(double orderAmntSubsProrated) {
		this.orderAmntSubsProrated = orderAmntSubsProrated;
	}

	public double getOrderAmntDeliveryOriginal() {
		return orderAmntDeliveryOriginal;
	}

	public void setOrderAmntDeliveryOriginal(double orderAmntDeliveryOriginal) {
		this.orderAmntDeliveryOriginal = orderAmntDeliveryOriginal;
	}

	public double getOrderAmntDeliveryProrated() {
		return orderAmntDeliveryProrated;
	}

	public void setOrderAmntDeliveryProrated(double orderAmntDeliveryProrated) {
		this.orderAmntDeliveryProrated = orderAmntDeliveryProrated;
	}

	public double getOrderAmntTaxOriginal() {
		return orderAmntTaxOriginal;
	}

	public void setOrderAmntTaxOriginal(double orderAmntTaxOriginal) {
		this.orderAmntTaxOriginal = orderAmntTaxOriginal;
	}

	public double getOrderAmntTaxProrated() {
		return orderAmntTaxProrated;
	}

	public void setOrderAmntTaxProrated(double orderAmntTaxProrated) {
		this.orderAmntTaxProrated = orderAmntTaxProrated;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "OrderThresholdInfo [id=" + id + ", orderClass=" + orderClass + ", customerNbr=" + customerNbr
				+ ", terms=" + terms + ", orderNbr=" + orderNbr + ", startDate=" + startDate + ", lineItem=" + lineItem
				+ ", sourceCode=" + sourceCode + ", orderDate=" + orderDate + ", order=" + order + ", totalPaid="
				+ totalPaid + ", paymentStatus=" + paymentStatus + ", underPaymentOption=" + underPaymentOption
				+ ", expirationOriginal=" + expirationOriginal + ", expirationProrated=" + expirationProrated
				+ ", orderQuantityOriginal=" + orderQuantityOriginal + ", orderQuantityProrated="
				+ orderQuantityProrated + ", remainingOriginal=" + remainingOriginal + ", remainingProrated="
				+ remainingProrated + ", orderAmntSubsOriginal=" + orderAmntSubsOriginal + ", orderAmntSubsProrated="
				+ orderAmntSubsProrated + ", orderAmntDeliveryOriginal=" + orderAmntDeliveryOriginal
				+ ", orderAmntDeliveryProrated=" + orderAmntDeliveryProrated + ", orderAmntTaxOriginal="
				+ orderAmntTaxOriginal + ", orderAmntTaxProrated=" + orderAmntTaxProrated + ", publisher=" + publisher
				+ "]";
	}
	
}
