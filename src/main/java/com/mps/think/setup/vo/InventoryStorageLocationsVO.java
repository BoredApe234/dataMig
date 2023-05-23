package com.mps.think.setup.vo;

public class InventoryStorageLocationsVO {
	
	private Integer id;
	
	private String location;
	
	private String areaLookup;
	
	private String alternateArea;
	
	private String bin;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAreaLookup() {
		return areaLookup;
	}

	public void setAreaLookup(String areaLookup) {
		this.areaLookup = areaLookup;
	}

	public String getAlternateArea() {
		return alternateArea;
	}

	public void setAlternateArea(String alternateArea) {
		this.alternateArea = alternateArea;
	}

	public String getBin() {
		return bin;
	}

	public void setBin(String bin) {
		this.bin = bin;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
