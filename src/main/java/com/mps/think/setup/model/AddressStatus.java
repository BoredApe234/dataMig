package com.mps.think.setup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="address_status")
public class AddressStatus extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "pub_id", referencedColumnName = "id")
	private Publisher pubId;
	
	@Column(name="defaultstatus")
	private Boolean defaultstatus;
	
	@Column(name="addressstatus")
	private String addressstatus;
	
	@Column(name="status")
	private String status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getDefaultstatus() {
		return defaultstatus;
	}

	public void setDefaultstatus(Boolean defaultstatus) {
		this.defaultstatus = defaultstatus;
	}

	public String getAddressstatus() {
		return addressstatus;
	}

	public void setAddressstatus(String addressstatus) {
		this.addressstatus = addressstatus;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Publisher getPubId() {
		return pubId;
	}

	public void setPubId(Publisher pubId) {
		this.pubId = pubId;
	}

	@Override
	public String toString() {
		return "AddressStatus [id=" + id + ", pubId=" + pubId + ", defaultstatus=" + defaultstatus + ", addressstatus="
				+ addressstatus + ", status=" + status + "]";
	}

	
	
	

}
