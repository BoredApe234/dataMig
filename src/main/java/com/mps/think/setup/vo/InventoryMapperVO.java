package com.mps.think.setup.vo;

public class InventoryMapperVO {
	
	private Integer inventoryId;
	
	private InventoryGeneralInformationVO generalInformation;
	
	private InventoryUnitInformationVO unitInformation;
	
	private InventoryOrderSettingsVO orderSettings;
	
	private InventoryTotalsVO inventoryTotals;
	
	private InventoryStorageLocationsVO primaryStorageLocation;
	
	private InventoryBulkTotalsVO bulkInventoryTotals;

	public InventoryGeneralInformationVO getGeneralInformation() {
		return generalInformation;
	}

	public void setGeneralInformation(InventoryGeneralInformationVO generalInformation) {
		this.generalInformation = generalInformation;
	}

	public InventoryUnitInformationVO getUnitInformation() {
		return unitInformation;
	}

	public void setUnitInformation(InventoryUnitInformationVO unitInformation) {
		this.unitInformation = unitInformation;
	}

	public InventoryOrderSettingsVO getOrderSettings() {
		return orderSettings;
	}

	public void setOrderSettings(InventoryOrderSettingsVO orderSettings) {
		this.orderSettings = orderSettings;
	}

	public InventoryTotalsVO getInventoryTotals() {
		return inventoryTotals;
	}

	public void setInventoryTotals(InventoryTotalsVO inventoryTotals) {
		this.inventoryTotals = inventoryTotals;
	}

	public InventoryStorageLocationsVO getPrimaryStorageLocation() {
		return primaryStorageLocation;
	}

	public void setPrimaryStorageLocation(InventoryStorageLocationsVO primaryStorageLocation) {
		this.primaryStorageLocation = primaryStorageLocation;
	}

	public InventoryBulkTotalsVO getBulkInventoryTotals() {
		return bulkInventoryTotals;
	}

	public void setBulkInventoryTotals(InventoryBulkTotalsVO bulkInventoryTotals) {
		this.bulkInventoryTotals = bulkInventoryTotals;
	}

	public Integer getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Integer inventoryId) {
		this.inventoryId = inventoryId;
	}

}
