package com.mps.think.setup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "renewal_definition_mapping")
public class RenewalDefinitionMapping extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "rdid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rdid;
	
	@ManyToOne
	@JoinColumn(name = "oc_id")
	private OrderClass orderClass;
	
	@ManyToOne
    @JoinColumn(name = "id")
	@JsonBackReference
	private RenewalDefinition renewalDefinition;



	public OrderClass getOrderClass() {
		return orderClass;
	}

	public void setOrderClass(OrderClass orderClass) {
		this.orderClass = orderClass;
	}

	public RenewalDefinition getRenewalDefinition() {
		return renewalDefinition;
	}

	public void setRenewalDefinition(RenewalDefinition renewalDefinition) {
		this.renewalDefinition = renewalDefinition;
	}

	public Integer getRdid() {
		return rdid;
	}

	public void setRdid(Integer rdid) {
		this.rdid = rdid;
	}
	
	

}
