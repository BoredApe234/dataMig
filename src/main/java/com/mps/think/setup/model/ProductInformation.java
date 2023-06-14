package com.mps.think.setup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product_information")
public class ProductInformation extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "product")
	private String product;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "price")
	private Double price;
	@ManyToOne
	@JoinColumn(name = "taxonomy", referencedColumnName = "id")
	private Taxonomy taxonomy;
	
	@Column(name = "size")
	private String size;
	
	@Column(name = "style")
	private String style;
	
	@Column(name = "colour")
	private String colour;
	
	@Column(name = "inventoryID")
	private String inventoryID;
	
	@ManyToOne
	@JoinColumn(name = "order_code", referencedColumnName = "id")
	private OrderCodesSuper orderCode;
	
	@ManyToOne
	@JoinColumn(name = "rate_card", referencedColumnName = "rcId")
	private RateCards rateCard;
	
	@Column(name = "tagLine")
	private String tagLine;
	
	@Column(name = "premium")
	private String premium;
	
	@ManyToOne
	@JoinColumn(name = "publisher_id", referencedColumnName = "id")
	private Publisher publisher;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Taxonomy getTaxonomy() {
		return taxonomy;
	}

	public void setTaxonomy(Taxonomy taxonomy) {
		this.taxonomy = taxonomy;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getInventoryID() {
		return inventoryID;
	}

	public void setInventoryID(String inventoryID) {
		this.inventoryID = inventoryID;
	}

	public OrderCodesSuper getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(OrderCodesSuper orderCode) {
		this.orderCode = orderCode;
	}

	public RateCards getRateCard() {
		return rateCard;
	}

	public void setRateCard(RateCards rateCard) {
		this.rateCard = rateCard;
	}

	public String getTagLine() {
		return tagLine;
	}

	public void setTagLine(String tagLine) {
		this.tagLine = tagLine;
	}

	public String getPremium() {
		return premium;
	}

	public void setPremium(String premium) {
		this.premium = premium;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "ProductInformation [id=" + id + ", product=" + product + ", description=" + description + ", price="
				+ price + ", taxonomy=" + taxonomy + ", size=" + size + ", style=" + style + ", colour=" + colour
				+ ", inventoryID=" + inventoryID + ", orderCode=" + orderCode + ", rateCard=" + rateCard + ", tagLine="
				+ tagLine + ", premium=" + premium + ", publisher=" + publisher + "]";
	}
}
