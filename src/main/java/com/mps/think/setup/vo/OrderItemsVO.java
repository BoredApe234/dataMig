package com.mps.think.setup.vo;

import java.util.Date;

import com.mps.think.setup.model.SubscriptionDefKeyInfo;
import com.mps.think.setup.model.Terms;

public class OrderItemsVO {
	
	private Integer id;

	private Integer issue;

	private String enumeration;

	private Integer copiesPerIssue;

	private SubscriptionDefKeyInfo subsProdPkgDef;

	private Date effectiveDate;

	private Integer numOfIssues;

	private Date validFrom;

	private Date validTo;

	private Integer liabilityIssue;

	private Integer extendedIssue;

	private Terms term;

	private Integer extendedByDays;

	private Integer quantityOrdered;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIssue() {
		return issue;
	}

	public void setIssue(Integer issue) {
		this.issue = issue;
	}

	public String getEnumeration() {
		return enumeration;
	}

	public void setEnumeration(String enumeration) {
		this.enumeration = enumeration;
	}

	public Integer getCopiesPerIssue() {
		return copiesPerIssue;
	}

	public void setCopiesPerIssue(Integer copiesPerIssue) {
		this.copiesPerIssue = copiesPerIssue;
	}

	public SubscriptionDefKeyInfo getSubsProdPkgDef() {
		return subsProdPkgDef;
	}

	public void setSubsProdPkgDef(SubscriptionDefKeyInfo subsProdPkgDef) {
		this.subsProdPkgDef = subsProdPkgDef;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public Integer getNumOfIssues() {
		return numOfIssues;
	}

	public void setNumOfIssues(Integer numOfIssues) {
		this.numOfIssues = numOfIssues;
	}

	public Date getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	public Integer getLiabilityIssue() {
		return liabilityIssue;
	}

	public void setLiabilityIssue(Integer liabilityIssue) {
		this.liabilityIssue = liabilityIssue;
	}

	public Integer getExtendedIssue() {
		return extendedIssue;
	}

	public void setExtendedIssue(Integer extendedIssue) {
		this.extendedIssue = extendedIssue;
	}

	public Terms getTerm() {
		return term;
	}

	public void setTerm(Terms term) {
		this.term = term;
	}

	public Integer getExtendedByDays() {
		return extendedByDays;
	}

	public void setExtendedByDays(Integer extendedByDays) {
		this.extendedByDays = extendedByDays;
	}

	public Integer getQuantityOrdered() {
		return quantityOrdered;
	}

	public void setQuantityOrdered(Integer quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}

	
	
}
