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

@Table(name = "area_details")
@Entity
public class AreaDetails extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2799554806828598845L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "area")
	private String area;
	
	@Column(name = "area_description")
	private String areaDescription;
	
	@Column(name = "area_is_active")
	private Boolean areaIsActive;
	
	@ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id")
	@JsonBackReference
	private LocationAreaDetails locationDetails;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getAreaDescription() {
		return areaDescription;
	}

	public void setAreaDescription(String areaDescription) {
		this.areaDescription = areaDescription;
	}

	public Boolean getAreaIsActive() {
		return areaIsActive;
	}

	public void setAreaIsActive(Boolean areaIsActive) {
		this.areaIsActive = areaIsActive;
	}
	
}
