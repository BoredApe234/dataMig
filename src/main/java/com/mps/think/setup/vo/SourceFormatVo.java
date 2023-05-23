package com.mps.think.setup.vo;

import java.util.List;

import com.mps.think.setup.model.Publisher;
import com.mps.think.setup.model.SourceFormatAndAttributeMapping;

public class SourceFormatVo {

	private Integer id;

	private String sourceFormat;

	private String description;

	private Integer mruSourceFormatSegmentSeq;
	
	private Publisher pubId;

	// @Enumerated(EnumType.STRING)
	// private AppConstants.codeGen codeGenType;
	// private Integer[] codeGenType;

	private List<SourceFormatAndAttributeMapping> attributeMappings;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSourceFormat() {
		return sourceFormat;
	}

	public void setSourceFormat(String sourceFormat) {
		this.sourceFormat = sourceFormat;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getMruSourceFormatSegmentSeq() {
		return mruSourceFormatSegmentSeq;
	}

	public void setMruSourceFormatSegmentSeq(Integer mruSourceFormatSegmentSeq) {
		this.mruSourceFormatSegmentSeq = mruSourceFormatSegmentSeq;
	}

	// public Integer[] getCodeGenType() {
	// return codeGenType;
	// }
	//
	// public void setCodeGenType(Integer[] codeGenType) {
	// this.codeGenType = codeGenType;
	// }

	public List<SourceFormatAndAttributeMapping> getAttributeMappings() {
		return attributeMappings;
	}

	public void setAttributeMappings(List<SourceFormatAndAttributeMapping> attributeMappings) {
		this.attributeMappings = attributeMappings;
	}

	public Publisher getPubId() {
		return pubId;
	}

	public void setPubId(Publisher pubId) {
		this.pubId = pubId;
	}

	@Override
	public String toString() {
		return "SourceFormatVo [id=" + id + ", sourceFormat=" + sourceFormat + ", description=" + description
				+ ", mruSourceFormatSegmentSeq=" + mruSourceFormatSegmentSeq + ", pubId=" + pubId
				+ ", attributeMappings=" + attributeMappings + "]";
	}

}
