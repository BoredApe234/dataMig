package com.mps.think.setup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "inventory_vendor_details")
@Entity
public class InventoryVendorDetails extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1821011089060286759L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "package_code")
	private String packageCode;
	
	@Column(name = "package_description")
	private String packageDescription;
	
	@OneToOne
	@JoinColumn(name = "vendor_details", referencedColumnName = "id" )
	private VendorDetails vendor;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPackageCode() {
		return packageCode;
	}

	public void setPackageCode(String packageCode) {
		this.packageCode = packageCode;
	}

	public String getPackageDescription() {
		return packageDescription;
	}

	public void setPackageDescription(String packageDescription) {
		this.packageDescription = packageDescription;
	}

	public VendorDetails getVendor() {
		return vendor;
	}

	public void setVendor(VendorDetails vendor) {
		this.vendor = vendor;
	}
	
}
