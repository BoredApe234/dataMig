package com.mps.think.setup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "order_auxiliary_information")
@Entity
public class OrderAuxiliaryInformation extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7157530880688318112L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "order_aux_json")
	private String orderAuxJSON;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderAuxJSON() {
		return orderAuxJSON;
	}

	public void setOrderAuxJSON(String orderAuxJSON) {
		this.orderAuxJSON = orderAuxJSON;
	}
	
}
