package com.mps.think.setup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "inventory_general_information")
@Entity
public class InventoryGeneralInformation extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7416348585032461615L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "inventory_code")
	private String inventoryCode;
	
	@Column(name = "inventory_id")
	private Integer inventoryId;
	
	@Column(name = "user_code")
	private String userCode;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "active_inventory_item")
	private Boolean activeInventoryItem;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

}
