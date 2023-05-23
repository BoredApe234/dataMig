package com.mps.think.setup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "oc")
@Entity
public class OrderClass {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "oc_id")
	private Integer ocId;
	
	@Column(name = "order_class")
	private String orderClassName;
	
	@Column(name = "oc_type")
	private String ocType;
	
	@Column(name="disallow_install_billing")
	private String disallowInstallBilling;
	
	@Column(name="do_cancel_credit_on_cancel")
	private String doCancelCreditOnCancel;
	
	@Column(name="low_sample_stock")
	private String lowSampleStock;
	
	@Column(name="low_stock")
	private String lowStock;
	
	@Column(name="new_group_member_action")
	private String newGroupMemberAction;
	
	@Column(name="post_conversion_reconcile")
	private String postConversionReconcile;
	
	@Column(name="sample_issue_selection")
	private String sampleIssueSelection;
	
	@Column(name="track_inven")
	private String trackInven;
	
	@Column(name="upsell_on")
	private String upsellOn;
	
	@OneToOne
	@JoinColumn(name = "pub_id", referencedColumnName = "id")
	private Publisher pubId;

	public Integer getOcId() {
		return ocId;
	}

	public void setOcId(Integer ocId) {
		this.ocId = ocId;
	}

	public String getOrderClassName() {
		return orderClassName;
	}

	public void setOrderClassName(String orderClassName) {
		this.orderClassName = orderClassName;
	}

	public String getOcType() {
		return ocType;
	}

	public void setOcType(String ocType) {
		this.ocType = ocType;
	}

	public String getDisallowInstallBilling() {
		return disallowInstallBilling;
	}

	public void setDisallowInstallBilling(String disallowInstallBilling) {
		this.disallowInstallBilling = disallowInstallBilling;
	}

	public String getDoCancelCreditOnCancel() {
		return doCancelCreditOnCancel;
	}

	public void setDoCancelCreditOnCancel(String doCancelCreditOnCancel) {
		this.doCancelCreditOnCancel = doCancelCreditOnCancel;
	}

	public String getLowSampleStock() {
		return lowSampleStock;
	}

	public void setLowSampleStock(String lowSampleStock) {
		this.lowSampleStock = lowSampleStock;
	}

	public String getLowStock() {
		return lowStock;
	}

	public void setLowStock(String lowStock) {
		this.lowStock = lowStock;
	}

	public String getNewGroupMemberAction() {
		return newGroupMemberAction;
	}

	public void setNewGroupMemberAction(String newGroupMemberAction) {
		this.newGroupMemberAction = newGroupMemberAction;
	}

	public String getPostConversionReconcile() {
		return postConversionReconcile;
	}

	public void setPostConversionReconcile(String postConversionReconcile) {
		this.postConversionReconcile = postConversionReconcile;
	}

	public String getSampleIssueSelection() {
		return sampleIssueSelection;
	}

	public void setSampleIssueSelection(String sampleIssueSelection) {
		this.sampleIssueSelection = sampleIssueSelection;
	}

	public String getTrackInven() {
		return trackInven;
	}

	public void setTrackInven(String trackInven) {
		this.trackInven = trackInven;
	}

	public String getUpsellOn() {
		return upsellOn;
	}

	public void setUpsellOn(String upsellOn) {
		this.upsellOn = upsellOn;
	}

	public Publisher getPubId() {
		return pubId;
	}

	public void setPubId(Publisher pubId) {
		this.pubId = pubId;
	}

	@Override
	public String toString() {
		return "OrderClass [ocId=" + ocId + ", orderClassName=" + orderClassName + ", ocType=" + ocType
				+ ", disallowInstallBilling=" + disallowInstallBilling + ", doCancelCreditOnCancel="
				+ doCancelCreditOnCancel + ", lowSampleStock=" + lowSampleStock + ", lowStock=" + lowStock
				+ ", newGroupMemberAction=" + newGroupMemberAction + ", postConversionReconcile="
				+ postConversionReconcile + ", sampleIssueSelection=" + sampleIssueSelection + ", trackInven="
				+ trackInven + ", upsellOn=" + upsellOn + ", pubId=" + pubId + "]";
	}

}
