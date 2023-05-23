package com.mps.think.setup.vo;

public class InventoryOrderSettingsVO {
	
	private Integer id;
	
	private Integer packageNumbers;
	
	private Integer unitPerPackage;
	
	private Boolean disallowAsSample;
	
	private String minimumForSamples;
	
	private String reorderPrint;
	
	private String lastShipment;

	public Integer getPackageNumbers() {
		return packageNumbers;
	}

	public void setPackageNumbers(Integer packageNumbers) {
		this.packageNumbers = packageNumbers;
	}

	public Integer getUnitPerPackage() {
		return unitPerPackage;
	}

	public void setUnitPerPackage(Integer unitPerPackage) {
		this.unitPerPackage = unitPerPackage;
	}

	public Boolean getDisallowAsSample() {
		return disallowAsSample;
	}

	public void setDisallowAsSample(Boolean disallowAsSample) {
		this.disallowAsSample = disallowAsSample;
	}

	public String getMinimumForSamples() {
		return minimumForSamples;
	}

	public void setMinimumForSamples(String minimumForSamples) {
		this.minimumForSamples = minimumForSamples;
	}

	public String getReorderPrint() {
		return reorderPrint;
	}

	public void setReorderPrint(String reorderPrint) {
		this.reorderPrint = reorderPrint;
	}

	public String getLastShipment() {
		return lastShipment;
	}

	public void setLastShipment(String lastShipment) {
		this.lastShipment = lastShipment;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
