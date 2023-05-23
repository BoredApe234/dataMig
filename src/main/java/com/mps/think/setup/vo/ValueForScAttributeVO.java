package com.mps.think.setup.vo;



import com.mps.think.setup.model.Publisher;

public class ValueForScAttributeVO {
	
    private Integer id;
	private Publisher pubId;
	private String valuesforthechosenattribute;
	private String description;
	private Integer width;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Publisher getPubId() {
		return pubId;
	}
	public void setPubId(Publisher pubId) {
		this.pubId = pubId;
	}
	public String getValuesforthechosenattribute() {
		return valuesforthechosenattribute;
	}
	public void setValuesforthechosenattribute(String valuesforthechosenattribute) {
		this.valuesforthechosenattribute = valuesforthechosenattribute;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getWidth() {
		return width;
	}
	public void setWidth(Integer width) {
		this.width = width;
	}
	
	


}
