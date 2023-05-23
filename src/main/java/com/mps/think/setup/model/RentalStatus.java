package com.mps.think.setup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "rental_status")
@Entity
public class RentalStatus extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rental_status_id")
	private Integer rentalStatusId;

	@Column(name = "rental_category")
	private String rentalcategory;

	@Column(name = "description")
	private String description;

	@Column(name = "rent_email")
	private Integer rentEmail;

	@Column(name = "rent_name")
	private Integer rentName;
	
	@OneToOne
	@JoinColumn(name = "pub_id", referencedColumnName = "id" )
	private Publisher publisher;

	public Integer getRentalStatusId() {
		return rentalStatusId;
	}

	public void setRentalStatusId(Integer rentalStatusId) {
		this.rentalStatusId = rentalStatusId;
	}

	public String getRentalcategory() {
		return rentalcategory;
	}

	public void setRentalcategory(String rentalcategory) {
		this.rentalcategory = rentalcategory;
	}

	public Integer getRentEmail() {
		return rentEmail;
	}

	public void setRentEmail(Integer rentEmail) {
		this.rentEmail = rentEmail;
	}

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getRentName() {
		return rentName;
	}

	public void setRentName(Integer rentName) {
		this.rentName = rentName;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "RentalStatus [rentalStatusId=" + rentalStatusId + ", rentalcategory=" + rentalcategory
				+ ", description=" + description + ", rentEmail=" + rentEmail + ", rentName=" + rentName
				+ ", publisher=" + publisher + "]";
	}

}