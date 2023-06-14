package com.mps.think.setup.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mps.think.setup.vo.EnumModelVO.OrderStatus;

@Entity
@Table(name = "reinstate_order_details")
public class ReinstateOrder extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

//	@Enumerated(EnumType.STRING)
	@Column(name = "current_order_status")
	private String currentOrderStatus;

	@Column(name = "suspended_from")
	private Date suspendedFrom;

	@Column(name = "suspended_to")
	private Date suspendedTo;

	@Column(name = "notes")
	private String notes;

	@OneToMany(mappedBy = "reinstateDetails", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<OrdersReinstated> ordersToReinstate;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getSuspendedFrom() {
		return suspendedFrom;
	}

	public void setSuspendedFrom(Date suspendedFrom) {
		this.suspendedFrom = suspendedFrom;
	}

	public Date getSuspendedTo() {
		return suspendedTo;
	}

	public void setSuspendedTo(Date suspendedTo) {
		this.suspendedTo = suspendedTo;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public List<OrdersReinstated> getOrdersToReinstate() {
		return ordersToReinstate;
	}

	public void setOrdersToReinstate(List<OrdersReinstated> ordersToReinstate) {
		this.ordersToReinstate = ordersToReinstate;
	}

	public void setCurrentOrderStatus(String currentOrderStatus) {
		this.currentOrderStatus = currentOrderStatus;
	}

	public String getCurrentOrderStatus() {
		return currentOrderStatus;
	}
	
}
