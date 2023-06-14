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
@Table(name = "inserts")
public class Inserts extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "bit")
	private Integer bit;
	
	@Column(name = "description")
	private String description;
	
	@OneToOne
	@JoinColumn(name = "ef_id", referencedColumnName = "id" )
	private ExtractFilter efid;
	
	@OneToOne
	@JoinColumn(name = "pr_id", referencedColumnName = "id" )
	private ProcessType pid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBit() {
		return bit;
	}

	public void setBit(Integer bit) {
		this.bit = bit;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ExtractFilter getEfid() {
		return efid;
	}

	public void setEfid(ExtractFilter efid) {
		this.efid = efid;
	}

	public ProcessType getPid() {
		return pid;
	}

	public void setPid(ProcessType pid) {
		this.pid = pid;
	}

	@Override
	public String toString() {
		return "Inserts [id=" + id + ", bit=" + bit + ", description=" + description + ", efid=" + efid + ", pid=" + pid
				+ "]";
	}
	
	

	
	
	
	

}
