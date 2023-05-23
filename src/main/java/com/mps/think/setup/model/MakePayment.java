package com.mps.think.setup.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="make_payment")
public class MakePayment extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="name_of_customer")
	private String nameOfCustomer;
	
	@Column(name="payer_customer")
	private String payerCustomer;
	
	@Column(name="base_amount")
	private double baseAmount;
	
	@Column(name="payment_account")
	private long paymentAccount;
	
	@Column(name="payment_type")
	private String paymentType;
	
	@Column(name="card")
	private String card;
	
	@Column(name="amount_to_be_paid")
	private double amountToBePaid;
	
	@Column(name="expiry_date")
	private String expiryDate;
	
	@Column(name="transaction_status")
	private String transactionStatus;
	
	@Column(name="charge_id")
	private String chargeId;
	
	@Column(name="status")
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "publisher_id", referencedColumnName = "id")
	private Publisher publisher;
	
	@OneToMany(
			mappedBy = "makePayment",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true)
	@JsonManagedReference
	private List<OrderPaymentMapping> orderPaymentMapping;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNameOfCustomer() {
		return nameOfCustomer;
	}

	public void setNameOfCustomer(String nameOfCustomer) {
		this.nameOfCustomer = nameOfCustomer;
	}

	public String getPayerCustomer() {
		return payerCustomer;
	}

	public void setPayerCustomer(String payerCustomer) {
		this.payerCustomer = payerCustomer;
	}

	public double getBaseAmount() {
		return baseAmount;
	}

	public void setBaseAmount(double baseAmount) {
		this.baseAmount = baseAmount;
	}

	public long getPaymentAccount() {
		return paymentAccount;
	}

	public void setPaymentAccount(long paymentAccount) {
		this.paymentAccount = paymentAccount;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public double getAmountToBePaid() {
		return amountToBePaid;
	}

	public void setAmountToBePaid(double amountToBePaid) {
		this.amountToBePaid = amountToBePaid;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public String getChargeId() {
		return chargeId;
	}

	public void setChargeId(String chargeId) {
		this.chargeId = chargeId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public List<OrderPaymentMapping> getOrderPaymentMapping() {
		return orderPaymentMapping;
	}

	public void setOrderPaymentMapping(List<OrderPaymentMapping> orderPaymentMapping) {
		this.orderPaymentMapping = orderPaymentMapping;
	}

	@Override
	public String toString() {
		return "MakePayment [id=" + id + ", nameOfCustomer=" + nameOfCustomer + ", payerCustomer=" + payerCustomer
				+ ", baseAmount=" + baseAmount + ", paymentAccount=" + paymentAccount + ", paymentType=" + paymentType
				+ ", card=" + card + ", amountToBePaid=" + amountToBePaid + ", expiryDate=" + expiryDate
				+ ", transactionStatus=" + transactionStatus + ", chargeId=" + chargeId + ", status=" + status
				+ ", publisher=" + publisher + ", orderPaymentMapping=" + orderPaymentMapping + "]";
	}
}
