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
@Table(name = "suspend_order")
public class SuspendOrder extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
//	@Enumerated(EnumType.STRING)
	@Column(name = "current_order_status")
	private String currentOrderStatus;
	
//	@Enumerated(EnumType.STRING)
	@Column(name = "set_order_status")
	private String setOrderStatus;
	
	@Column(name = "reason_for_suspension")
	private String reasonForSuspension;
	
	@Column(name = "suspended_from")
	private Date suspendedfrom;
	
	@Column(name = "suspended_to")
	private Date suspendedTo;
	
	@Column(name = "notes")
	private String notes;
	
	@OneToMany(mappedBy = "suspendOrder", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<OrdersToBeSuspended> ordersToSuspend;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getReasonForSuspension() {
		return reasonForSuspension;
	}

	public void setReasonForSuspension(String reasonForSuspension) {
		this.reasonForSuspension = reasonForSuspension;
	}

	public Date getSuspendedfrom() {
		return suspendedfrom;
	}

	public void setSuspendedfrom(Date suspendedfrom) {
		this.suspendedfrom = suspendedfrom;
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

	public List<OrdersToBeSuspended> getOrdersToSuspend() {
		return ordersToSuspend;
	}

	public void setOrdersToSuspend(List<OrdersToBeSuspended> ordersToSuspend) {
		this.ordersToSuspend = ordersToSuspend;
	}

	public String getCurrentOrderStatus() {
		return currentOrderStatus;
	}

	public void setCurrentOrderStatus(String currentOrderStatus) {
		this.currentOrderStatus = currentOrderStatus;
	}

	public String getSetOrderStatus() {
		return setOrderStatus;
	}

	public void setSetOrderStatus(String setOrderStatus) {
		this.setOrderStatus = setOrderStatus;
	}

}
