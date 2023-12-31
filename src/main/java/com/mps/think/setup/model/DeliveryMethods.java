package com.mps.think.setup.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "delivery_methods")
public class DeliveryMethods extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9038699163341242113L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "delivery_methods_id")
	private Integer deliveryMethodsId;
	
	@Column(name = "default_delivery")
	private Boolean defaultDelivery;
	
	@Column(name = "delivery_method")
	private String deliveryMethod;
	
	@Column(name = "active")
	private Boolean active;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "region_list")
	private String regionList;
	
	@Column(name = "delivery_amount")
	private Double amount;
	
	@Column(name = "transport_mode")
	private String transportMode;
	
	@OneToOne
	@JoinColumn(name = "publisher_id")
	private Publisher publisher;

	public Integer getDeliveryMethodsId() {
		return deliveryMethodsId;
	}

	public void setDeliveryMethodsId(Integer deliveryMethodsId) {
		this.deliveryMethodsId = deliveryMethodsId;
	}

	public Boolean getDefaultDelivery() {
		return defaultDelivery;
	}

	public void setDefaultDelivery(Boolean defaultDelivery) {
		this.defaultDelivery = defaultDelivery;
	}

	public String getDeliveryMethod() {
		return deliveryMethod;
	}

	public void setDeliveryMethod(String deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRegionList() {
		return regionList;
	}

	public void setRegionList(String regionList) {
		this.regionList = regionList;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getTransportMode() {
		return transportMode;
	}

	public void setTransportMode(String transportMode) {
		this.transportMode = transportMode;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	
	
}
