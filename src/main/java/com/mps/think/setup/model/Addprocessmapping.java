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
@Table(name = "process_mapping_oc")
public class Addprocessmapping extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pmid")
	private Integer pmid;
	
	@ManyToOne
	@JoinColumn(name = "oc_id")
	private OrderClass orderClass;
	
	@ManyToOne
    @JoinColumn(name = "id")
	@JsonBackReference
	private AddProcess addProcess;

	public Integer getPmid() {
		return pmid;
	}

	public void setPmid(Integer pmid) {
		this.pmid = pmid;
	}

	public OrderClass getOrderClass() {
		return orderClass;
	}

	public void setOrderClass(OrderClass orderClass) {
		this.orderClass = orderClass;
	}

	public AddProcess getAddProcess() {
		return addProcess;
	}

	public void setAddProcess(AddProcess addProcess) {
		this.addProcess = addProcess;
	}



	
	

}
