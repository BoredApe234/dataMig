package com.mps.think.setup.vo;

public class InventoryGeneralInformationVO {
	
	private Integer id;
	
	private String inventoryCode;
	
	private Integer inventoryId;
	
	private String userCode;
	
	private String description;
	
	private Boolean activeInventoryItem;

	public String getInventoryCode() {
		return inventoryCode;
	}

	public void setInventoryCode(String inventoryCode) {
		this.inventoryCode = inventoryCode;
	}

	public Integer getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Integer inventoryId) {
		this.inventoryId = inventoryId;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getActiveInventoryItem() {
		return activeInventoryItem;
	}

	public void setActiveInventoryItem(Boolean activeInventoryItem) {
		this.activeInventoryItem = activeInventoryItem;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
