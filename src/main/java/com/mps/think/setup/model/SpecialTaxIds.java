package com.mps.think.setup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Special_Tax_IDs")
public class SpecialTaxIds extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@OneToOne
	@JoinColumn(name = "pub_id", referencedColumnName = "id")
	private Publisher pubId;
	
	@Column(name = "specialTaxIds")
	private String specialTaxIds;
	
	@Column(name = "exemptStatus")
	private boolean exemptStatus;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Publisher getPubId() {
		return pubId;
	}

	public void setPubId(Publisher pubId) {
		this.pubId = pubId;
	}

	public String getSpecialTaxIds() {
		return specialTaxIds;
	}

	public void setSpecialTaxIds(String specialTaxIds) {
		this.specialTaxIds = specialTaxIds;
	}

	public boolean getExemptStatus() {
		return exemptStatus;
	}

	public void setExemptStatus(boolean exemptStatus) {
		this.exemptStatus = exemptStatus;
	}

	@Override
	public String toString() {
		return "SpecialTaxIds [id=" + id + ", pubId=" + pubId + ", specialTaxIds=" + specialTaxIds + ", exemptStatus="
				+ exemptStatus + "]";
	}

}
