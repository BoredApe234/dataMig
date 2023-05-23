package com.mps.think.setup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "parent_child_mapping")
@Entity
public class ParentChildMapping {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@OneToOne
	@JoinColumn(name="parent_id", referencedColumnName="oc_id")
	private OrderClass parentId;
	
	@OneToOne
	@JoinColumn(name="child_id", referencedColumnName="oc_id")
	private OrderClass childId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public OrderClass getParentId() {
		return parentId;
	}

	public void setParentId(OrderClass parentId) {
		this.parentId = parentId;
	}

	public OrderClass getChildId() {
		return childId;
	}

	public void setChildId(OrderClass childId) {
		this.childId = childId;
	}

	@Override
	public String toString() {
		return "ParentChildMapping [id=" + id + ", parentId=" + parentId + ", childId=" + childId + "]";
	}
	
	
}
