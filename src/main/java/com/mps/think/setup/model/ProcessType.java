package com.mps.think.setup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "process_type")
public class ProcessType extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "p_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pid;
	
	@Column(name = "mainpurposelabel")
	private String mainpurposelabel;

	

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getMainpurposelabel() {
		return mainpurposelabel;
	}

	public void setMainpurposelabel(String mainpurposelabel) {
		this.mainpurposelabel = mainpurposelabel;
	}

	
	
	

}
