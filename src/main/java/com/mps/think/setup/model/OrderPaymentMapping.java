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
@Table(name="Order_payment_mapping")
public class OrderPaymentMapping {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "order_id",referencedColumnName="order_id")
	private Order order;
	
	@ManyToOne
    @JoinColumn(name = "make_payment_id",referencedColumnName="id")
	@JsonBackReference
	private MakePayment makePayment;

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

	public MakePayment getMakePayment() {
		return makePayment;
	}

	public void setMakePayment(MakePayment makePayment) {
		this.makePayment = makePayment;
	}

	@Override
	public String toString() {
		return "OrderPayment [id=" + id + ", order=" + order + ", makePayment=" + makePayment + "]";
	}
}
