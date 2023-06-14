package com.mps.think.setup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Table(name = "region_list_mapping")
@Entity
public class RegionListMapping extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rlid")
	private Integer rlid;
	
	@ManyToOne
	@JoinColumn(name = "cid")
	private CountryInfo countryInfo;
	
	@ManyToOne
    @JoinColumn(name = "rid" )
	@JsonBackReference
	private RegionList regionList;

	public Integer getRlid() {
		return rlid;
	}

	public void setRlid(Integer rlid) {
		this.rlid = rlid;
	}

	public CountryInfo getCountryInfo() {
		return countryInfo;
	}

	public void setCountryInfo(CountryInfo countryInfo) {
		this.countryInfo = countryInfo;
	}

	public RegionList getRegionList() {
		return regionList;
	}

	public void setRegionList(RegionList regionList) {
		this.regionList = regionList;
	}

	@Override
	public String toString() {
		return "RegionListMapping [rlid=" + rlid + ", countryInfo=" + countryInfo + ", regionList=" + regionList + "]";
	}
	
	
	
	

}
