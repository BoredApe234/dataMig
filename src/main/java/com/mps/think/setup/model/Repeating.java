package com.mps.think.setup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "repeating_interval")
public class Repeating extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "intervalunit")
	private String intervalunit;
	
	@Column(name = "nointunits")
	private Integer nointunits;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIntervalunit() {
		return intervalunit;
	}

	public void setIntervalunit(String intervalunit) {
		this.intervalunit = intervalunit;
	}

	public Integer getNointunits() {
		return nointunits;
	}

	public void setNointunits(Integer nointunits) {
		this.nointunits = nointunits;
	}

	@Override
	public String toString() {
		return "Repeating [id=" + id + ", intervalunit=" + intervalunit + ", nointunits=" + nointunits + "]";
	}
	
	

}
