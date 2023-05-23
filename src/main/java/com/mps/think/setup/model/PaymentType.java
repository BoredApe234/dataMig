package com.mps.think.setup.model;

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

import com.mps.think.setup.vo.EnumModelVO.CVVValues;
import com.mps.think.setup.vo.EnumModelVO.RealiseCashWhen;

@Entity
@Table(name = "payment_type")
public class PaymentType extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "payment_type")
	private String paymentType;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "payment_form")
	private String paymentForm;
	
//	@Enumerated(EnumType.STRING)
	@Column(name = "realise_cash_when")
	private String realiseCashWhen; // dropdown
	
	@Column(name = "use_as_default")
	private Boolean useAsDefault;
	
	@Column(name = "credit_card_type")
	private String creditCardType;
	
//	@Enumerated(EnumType.STRING)
	@Column(name = "cvv_val")
	private String cvv; // dropdown
	
	@ManyToOne
	@JoinColumn(name = "publisher_id", referencedColumnName = "id")
	private Publisher publisher;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPaymentForm() {
		return paymentForm;
	}

	public void setPaymentForm(String paymentForm) {
		this.paymentForm = paymentForm;
	}

	public Boolean getUseAsDefault() {
		return useAsDefault;
	}

	public void setUseAsDefault(Boolean useAsDefault) {
		this.useAsDefault = useAsDefault;
	}

	public String getCreditCardType() {
		return creditCardType;
	}

	public void setCreditCardType(String creditCardType) {
		this.creditCardType = creditCardType;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public String getRealiseCashWhen() {
		return realiseCashWhen;
	}

	public void setRealiseCashWhen(String realiseCashWhen) {
		this.realiseCashWhen = realiseCashWhen;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

}
