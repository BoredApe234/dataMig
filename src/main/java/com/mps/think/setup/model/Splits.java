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
@Table(name = "splits")
public class Splits extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "value")
	private String value;
	
	@Column(name = "description")
	private String description;
	
	@OneToOne
	@JoinColumn(name = "extractfilter", referencedColumnName = "id" )
	private ExtractFilter extractfilterid;
	
	@OneToOne
	@JoinColumn(name = "process", referencedColumnName = "id" )
	private ProcessType pid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ExtractFilter getExtractfilterid() {
		return extractfilterid;
	}

	public void setExtractfilterid(ExtractFilter extractfilterid) {
		this.extractfilterid = extractfilterid;
	}

	public ProcessType getPid() {
		return pid;
	}

	public void setPid(ProcessType pid) {
		this.pid = pid;
	}

	@Override
	public String toString() {
		return "Splits [id=" + id + ", value=" + value + ", description=" + description + ", extractfilterid="
				+ extractfilterid + ", pid=" + pid + "]";
	}


	
	
	
	

}
