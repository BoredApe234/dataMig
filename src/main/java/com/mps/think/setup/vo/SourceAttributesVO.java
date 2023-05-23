package com.mps.think.setup.vo;

import com.mps.think.setup.model.Publisher;
import com.mps.think.setup.model.SourceAttributeValues;

public class SourceAttributesVO {

	private Integer id;

	private Publisher publisher;

	private String attribute;

//	private SourceAttributeValues value;
	private String value;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	

	
	
	

}