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
@Table(name = "reinstated_orders")
public class OrdersReinstated extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "reinstate_order_det_id")
	@JsonBackReference
	private ReinstateOrder reinstateDetails;
	
	@OneToOne
	@JoinColumn(name = "suspend_order_det_id", referencedColumnName = "id")
	private SuspendOrder suspendOrder;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public ReinstateOrder getReinstateDetails() {
		return reinstateDetails;
	}

	public void setReinstateDetails(ReinstateOrder reinstateDetails) {
		this.reinstateDetails = reinstateDetails;
	}

	public SuspendOrder getSuspendOrder() {
		return suspendOrder;
	}

	public void setSuspendOrder(SuspendOrder suspendOrder) {
		this.suspendOrder = suspendOrder;
	}
	
}
