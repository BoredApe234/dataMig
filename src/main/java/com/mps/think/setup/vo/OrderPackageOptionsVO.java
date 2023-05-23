package com.mps.think.setup.vo;

import com.mps.think.setup.model.Publisher;

public class OrderPackageOptionsVO {

	private Integer id;

//	private Integer publisherId;

	private String premiumOptions;

	private String shipPremium;

	private Boolean packageOnly;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPremiumOptions() {
		return premiumOptions;
	}

	public void setPremiumOptions(String premiumOptions) {
		this.premiumOptions = premiumOptions;
	}

	public String getShipPremium() {
		return shipPremium;
	}

	public void setShipPremium(String shipPremium) {
		this.shipPremium = shipPremium;
	}

	public Boolean getPackageOnly() {
		return packageOnly;
	}

	public void setPackageOnly(Boolean packageOnly) {
		this.packageOnly = packageOnly;
	}

	
}
