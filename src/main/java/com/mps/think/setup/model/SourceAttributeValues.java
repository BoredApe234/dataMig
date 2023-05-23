package com.mps.think.setup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name="source_attribute_values")
@Entity
public class SourceAttributeValues extends BaseEntity {

	/**
	 * 1
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "publisher_id", referencedColumnName = "id")
	private Publisher publisher;
	
	@ManyToOne
	@JoinColumn(name = "sourceAttributes_id", referencedColumnName = "id")
	private SourceAttributes sourceAttributesId;
	 
	@Column(name = "chosen_attribute_value")
	private String chosenAttributeValue;
	
	@Column(name = "description")
	private String description;
	
	@Column(name="max_character_length")
	private Integer maxCharacterLen;

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

	public SourceAttributes getSourceAttributesId() {
		return sourceAttributesId;
	}

	public void setSourceAttributesId(SourceAttributes sourceAttributesId) {
		this.sourceAttributesId = sourceAttributesId;
	}

	public String getChosenAttributeValue() {
		return chosenAttributeValue;
	}

	public void setChosenAttributeValue(String chosenAttributeValue) {
		this.chosenAttributeValue = chosenAttributeValue;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getMaxCharacterLen() {
		return maxCharacterLen;
	}

	public void setMaxCharacterLen(Integer maxCharacterLen) {
		this.maxCharacterLen = maxCharacterLen;
	}

	

	


}