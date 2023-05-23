package com.mps.think.setup.vo;

import com.mps.think.setup.model.OrderClass;

public class ParentChildMappingVO {

	private Integer id;

	private OrderClass parentId;

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
		return "ParentChildMappingVO [id=" + id + ", parentId=" + parentId + ", childId=" + childId + "]";
	}
	
}
