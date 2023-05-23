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

import com.fasterxml.jackson.annotation.JsonBackReference;

@Table(name = "order_address_mapping")
@Entity
public class OrderAddressMapping extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2896231971485236016L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
//	@Column(name = "address_id")
//	private Integer addressId;]
	
	@OneToOne
	@JoinColumn(name = "address", referencedColumnName = "address_id")
	private Addresses address;
	
	@Column(name = "shipping_address")
	private Boolean shippingAddress;
	
	@Column(name = "billing_address")
	private Boolean billingAddress;
	
	@Column(name = "alternate_address")
	private Boolean alternateAddress;
	
	@Column(name = "renewal_address")
	private Boolean renewalAddress;
	
	@ManyToOne
    @JoinColumn(name = "order_id")
	@JsonBackReference
    private Order order;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Addresses getAddress() {
		return address;
	}

	public void setAddress(Addresses address) {
		this.address = address;
	}

	public Boolean getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Boolean shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Boolean getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Boolean billingAddress) {
		this.billingAddress = billingAddress;
	}

	public Boolean getAlternateAddress() {
		return alternateAddress;
	}

	public void setAlternateAddress(Boolean alternateAddress) {
		this.alternateAddress = alternateAddress;
	}

	public Boolean getRenewalAddress() {
		return renewalAddress;
	}

	public void setRenewalAddress(Boolean renewalAddress) {
		this.renewalAddress = renewalAddress;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
