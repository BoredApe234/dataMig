package com.mps.think.setup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "process_table")
public class AddProcess extends BaseEntity  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "process_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer process_id;
	
	@OneToOne
	@JoinColumn(name = "process_type_id", referencedColumnName = "p_id" )
	private ProcessType processtypeid;
	
	@Column(name = "mainpurpose")
	private String mainpurpose;

	@Column(name = "description")
	private String description;
	
	@Column(name = "status")
	private Boolean status;
	
	@Column(name = "active")
	private Boolean active;
	
	@Column(name = "repeating")
	private Boolean repeating;
	
	@Column(name = "holdormanualselect")
	private Boolean holdormanualselect;
	
	@Column(name = "backlabel")
	private Boolean backlabel;
	
	@Column(name = "billing")
	private Boolean billing;
	
	@Column(name = "productfullfillment")
	private Boolean productfullfillment;
	
	@Column(name = "refund")
	private Boolean refund;
	
	@Column(name = "renewal")
	private Boolean renewal;
	
	@Column(name = "extractfilter")
	private String extractfilter;
	
	@Column(name = "defaultjobpriority")
	private String defaultjobpriority;
	
	@Column(name = "outputsort")
	private String outputsort;
	
	@Column(name = "defaultjobqueue")
	private String defaultjobqueue;
	
	@Column(name = "sqlscript")
	private String sqlscript;
	
	@ManyToOne
	@JoinColumn(name = "order_cls_id", referencedColumnName = "oc_id")
	private OrderClass orderClass;
	
	@Column(name = "length")
	private String length;
	
	@Column(name = "gps")
	private Integer gps;
	
	@Column(name = "keyline")
	private Integer keyline;
	
	@Column(name = "gracenewexpires")
	private Boolean gracenewexpires;
	
	@Column(name = "savecurrentgraces")
	private Boolean savecurrentgraces;
	
	@Column(name = "bundlethreshold")
	private String bundlethreshold;
	
	@Column(name = "prioritysort")
	private String prioritysort;
	
	@Column(name = "picklist")
	private Boolean picklist;

	public Integer getProcess_id() {
		return process_id;
	}

	public void setProcess_id(Integer process_id) {
		this.process_id = process_id;
	}

	public ProcessType getProcesstypeid() {
		return processtypeid;
	}

	public void setProcesstypeid(ProcessType processtypeid) {
		this.processtypeid = processtypeid;
	}

	public String getMainpurpose() {
		return mainpurpose;
	}

	public void setMainpurpose(String mainpurpose) {
		this.mainpurpose = mainpurpose;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean getRepeating() {
		return repeating;
	}

	public void setRepeating(Boolean repeating) {
		this.repeating = repeating;
	}

	public Boolean getHoldormanualselect() {
		return holdormanualselect;
	}

	public void setHoldormanualselect(Boolean holdormanualselect) {
		this.holdormanualselect = holdormanualselect;
	}

	public Boolean getBacklabel() {
		return backlabel;
	}

	public void setBacklabel(Boolean backlabel) {
		this.backlabel = backlabel;
	}

	public Boolean getBilling() {
		return billing;
	}

	public void setBilling(Boolean billing) {
		this.billing = billing;
	}

	public Boolean getProductfullfillment() {
		return productfullfillment;
	}

	public void setProductfullfillment(Boolean productfullfillment) {
		this.productfullfillment = productfullfillment;
	}

	public Boolean getRefund() {
		return refund;
	}

	public void setRefund(Boolean refund) {
		this.refund = refund;
	}

	public Boolean getRenewal() {
		return renewal;
	}

	public void setRenewal(Boolean renewal) {
		this.renewal = renewal;
	}

	public String getExtractfilter() {
		return extractfilter;
	}

	public void setExtractfilter(String extractfilter) {
		this.extractfilter = extractfilter;
	}

	public String getDefaultjobpriority() {
		return defaultjobpriority;
	}

	public void setDefaultjobpriority(String defaultjobpriority) {
		this.defaultjobpriority = defaultjobpriority;
	}

	public String getOutputsort() {
		return outputsort;
	}

	public void setOutputsort(String outputsort) {
		this.outputsort = outputsort;
	}

	public String getDefaultjobqueue() {
		return defaultjobqueue;
	}

	public void setDefaultjobqueue(String defaultjobqueue) {
		this.defaultjobqueue = defaultjobqueue;
	}

	public String getSqlscript() {
		return sqlscript;
	}

	public void setSqlscript(String sqlscript) {
		this.sqlscript = sqlscript;
	}

	public OrderClass getOrderClass() {
		return orderClass;
	}

	public void setOrderClass(OrderClass orderClass) {
		this.orderClass = orderClass;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public Integer getGps() {
		return gps;
	}

	public void setGps(Integer gps) {
		this.gps = gps;
	}

	public Integer getKeyline() {
		return keyline;
	}

	public void setKeyline(Integer keyline) {
		this.keyline = keyline;
	}

	public Boolean getGracenewexpires() {
		return gracenewexpires;
	}

	public void setGracenewexpires(Boolean gracenewexpires) {
		this.gracenewexpires = gracenewexpires;
	}

	public Boolean getSavecurrentgraces() {
		return savecurrentgraces;
	}

	public void setSavecurrentgraces(Boolean savecurrentgraces) {
		this.savecurrentgraces = savecurrentgraces;
	}

	public String getBundlethreshold() {
		return bundlethreshold;
	}

	public void setBundlethreshold(String bundlethreshold) {
		this.bundlethreshold = bundlethreshold;
	}

	public String getPrioritysort() {
		return prioritysort;
	}

	public void setPrioritysort(String prioritysort) {
		this.prioritysort = prioritysort;
	}

	public Boolean getPicklist() {
		return picklist;
	}

	public void setPicklist(Boolean picklist) {
		this.picklist = picklist;
	}

	
	
	
	
	
	
	
	
	

}
