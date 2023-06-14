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

@Entity
@Table(name = "orders_to_be_suspended")
public class OrdersToBeSuspended extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "suspend_order_id")
	@JsonBackReference
	private SuspendOrder suspendOrder;
	
	@OneToOne
	@JoinColumn(name = "order_id")
	private Order order;
	
	@Column(name = "is_reinstated")
	private Boolean isReinstated;
	
	@Column(name = "is_suspended")
	private Boolean isSuspended;
	
	@Column(name = "is_valid")
	private Boolean isValid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SuspendOrder getSuspendOrder() {
		return suspendOrder;
	}

	public void setSuspendOrder(SuspendOrder suspendOrder) {
		this.suspendOrder = suspendOrder;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Boolean getIsReinstated() {
		return isReinstated;
	}

	public void setIsReinstated(Boolean isReinstated) {
		this.isReinstated = isReinstated;
	}

	public Boolean getIsSuspended() {
		return isSuspended;
	}

	public void setIsSuspended(Boolean isSuspended) {
		this.isSuspended = isSuspended;
	}

	public Boolean getIsValid() {
		return isValid;
	}

	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}

}
