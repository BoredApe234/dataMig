package com.mps.think.setup.vo;

import com.mps.think.setup.model.Publisher;

public class ProfitCenterVO {

	private Integer proftId;
	private String profitDescription;

	private String profitCenter;
	private Integer inclTaxLiab;
	private Integer inclDelLiab;
	private Integer inclComLiab;
	private Integer inclTaxAr;
	private Integer inclDelAr;
	private Integer inclComAr;
	private Publisher pubId;

	public Integer getProftId() {
		return proftId;
	}

	public void setProftId(Integer proftId) {
		this.proftId = proftId;
	}

	public String getProfitDescription() {
		return profitDescription;
	}

	public void setProfitDescription(String profitDescription) {
		this.profitDescription = profitDescription;
	}

	public Integer getInclTaxLiab() {
		return inclTaxLiab;
	}

	public void setInclTaxLiab(Integer inclTaxLiab) {
		this.inclTaxLiab = inclTaxLiab;
	}

	public Integer getInclDelLiab() {
		return inclDelLiab;
	}

	public void setInclDelLiab(Integer inclDelLiab) {
		this.inclDelLiab = inclDelLiab;
	}

	public Integer getInclComLiab() {
		return inclComLiab;
	}

	public void setInclComLiab(Integer inclComLiab) {
		this.inclComLiab = inclComLiab;
	}

	public Integer getInclTaxAr() {
		return inclTaxAr;
	}

	public void setInclTaxAr(Integer inclTaxAr) {
		this.inclTaxAr = inclTaxAr;
	}

	public Integer getInclDelAr() {
		return inclDelAr;
	}

	public void setInclDelAr(Integer inclDelAr) {
		this.inclDelAr = inclDelAr;
	}

	public Integer getInclComAr() {
		return inclComAr;
	}

	public void setInclComAr(Integer inclComAr) {
		this.inclComAr = inclComAr;
	}
	

	public String getProfitCenter() {
		return profitCenter;
	}

	public void setProfitCenter(String profitCenter) {
		this.profitCenter = profitCenter;
	}
	

	public Publisher getPubId() {
		return pubId;
	}

	public void setPubId(Publisher pubId) {
		this.pubId = pubId;
	}

	@Override
	public String toString() {
		return "ProfitCenterVO [proftId=" + proftId + ", profitDescription=" + profitDescription + ", profitCenter="
				+ profitCenter + ", inclTaxLiab=" + inclTaxLiab + ", inclDelLiab=" + inclDelLiab + ", inclComLiab="
				+ inclComLiab + ", inclTaxAr=" + inclTaxAr + ", inclDelAr=" + inclDelAr + ", inclComAr=" + inclComAr
				+ ", pubId=" + pubId + "]";
	}


}