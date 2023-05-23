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
@Table(name="add_payment")
public class AddPayment extends BaseEntity{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="type_of_payment_account")
	private String typeOfPaymentAccount;
	
	@Column(name="select_credit_card")
	private boolean selectCreditCard;
	
	@Column(name="select_credit_card_with_token")
	private boolean selectCreditCardWithToken;
	
	@Column(name="credit_card")
	private long creditCard;
	
	@Column(name="token")
	private String token;
	
	@Column(name="credit_card_last_digit")
	private String creditCardLastDigit;
	
	@Column(name="card_type")
	private String cardType;
	
	@Column(name="name_of_card_holder")
	private String nameOfCardHolder;
	
	@Column(name="valid_from")
	private Date  validFrom;
	
	@Column(name="valid_to")
	private Date  validTo;
	
	@OneToOne
	@JoinColumn(name = "customer_details", referencedColumnName = "id" )
	private CustomerDetails customerDetails;
	
	@OneToOne
	@JoinColumn(name = "pub_id", referencedColumnName = "id" )
	private Publisher publisher;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTypeOfPaymentAccount() {
		return typeOfPaymentAccount;
	}

	public void setTypeOfPaymentAccount(String typeOfPaymentAccount) {
		this.typeOfPaymentAccount = typeOfPaymentAccount;
	}

	public boolean isSelectCreditCard() {
		return selectCreditCard;
	}

	public void setSelectCreditCard(boolean selectCreditCard) {
		this.selectCreditCard = selectCreditCard;
	}

	public boolean isSelectCreditCardWithToken() {
		return selectCreditCardWithToken;
	}

	public void setSelectCreditCardWithToken(boolean selectCreditCardWithToken) {
		this.selectCreditCardWithToken = selectCreditCardWithToken;
	}

	public long getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(long creditCard) {
		this.creditCard = creditCard;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getCreditCardLastDigit() {
		return creditCardLastDigit;
	}

	public void setCreditCardLastDigit(String creditCardLastDigit) {
		this.creditCardLastDigit = creditCardLastDigit;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getNameOfCardHolder() {
		return nameOfCardHolder;
	}

	public void setNameOfCardHolder(String nameOfCardHolder) {
		this.nameOfCardHolder = nameOfCardHolder;
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

	public CustomerDetails getCustomerDetails() {
		return customerDetails;
	}

	public void setCustomerDetails(CustomerDetails customerDetails) {
		this.customerDetails = customerDetails;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "AddPayment [id=" + id + ", typeOfPaymentAccount=" + typeOfPaymentAccount + ", selectCreditCard="
				+ selectCreditCard + ", selectCreditCardWithToken=" + selectCreditCardWithToken
				+ ", creditCard=" + creditCard + ", token=" + token + ", creditCardLastDigit=" + creditCardLastDigit
				+ ", cardType=" + cardType + ", nameOfCardHolder=" + nameOfCardHolder + ", validFrom=" + validFrom
				+ ", validTo=" + validTo + ", customerDetails=" + customerDetails + ", publisher=" + publisher + "]";
	}

	
}
