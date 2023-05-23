package com.mps.think.setup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "inventory_order_settings")
@Entity
public class InventoryOrderSettings extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7049801192685510318L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "package_numbers")
	private Integer packageNumbers;
	
	@Column(name = "unit_per_package")
	private Integer unitPerPackage;
	
	@Column(name = "disallow_as_sample")
	private Boolean disallowAsSample;
	
	@Column(name = "minimum_for_samples")
	private String minimumForSamples;
	
	@Column(name = "reorder_print")
	private String reorderPrint;
	
	@Column(name = "last_shipment")
	private String lastShipment;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

}
