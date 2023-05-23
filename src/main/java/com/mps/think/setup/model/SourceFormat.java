package com.mps.think.setup.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Table(name = "source_format")
@Entity
public class SourceFormat extends BaseEntity {

	/**
	 * 3
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "source_format")
	private String sourceFormat;

	@Column(name = "description")
	private String description;

	@Column(name = "mru_source_format_segment_seq")
	private Integer mruSourceFormatSegmentSeq;
	
	@OneToOne
	@JoinColumn(name = "pub_id", referencedColumnName = "id" )
	private Publisher pubId;

//	@Enumerated(EnumType.STRING)
//	@Column(name = "code_gen_type")
//	private Integer[] codeGenType;
//	private AppConstants.codeGen codeGenType;
	
	@OneToMany(
			mappedBy = "sourceFormat",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true)
	@JsonManagedReference
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

//	public Integer[] getCodeGenType() {
//		return codeGenType;
//	}
//
//	public void setCodeGenType(Integer[] codeGenType) {
//		this.codeGenType = codeGenType;
//	}

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
		return "SourceFormat [id=" + id + ", sourceFormat=" + sourceFormat + ", description=" + description
				+ ", mruSourceFormatSegmentSeq=" + mruSourceFormatSegmentSeq + ", pubId=" + pubId
				+ ", attributeMappings=" + attributeMappings + "]";
	}

}
