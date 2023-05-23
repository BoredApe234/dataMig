package com.mps.think.setup.model;

import java.util.Date;

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
@Table(name = "jobs")
public class SubmitJob extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "addProcess_id", referencedColumnName = "process_id" )
	private AddProcess addProcessId;
	
	@OneToOne
	@JoinColumn(name = "processoutput_id", referencedColumnName = "output_id" )
	private ProcessOutput processOutputId;

	@Column(name = "jobdescription")
	private String jobdescription;
	
	@Column(name = "runjoblocally")
	private Boolean runjoblocally;
	
	@Column(name = "jobnotes")
	private String jobnotes;
	
	@Column(name = "defaultjobqueue")
	private String defaultjobqueue;
	
	@Column(name = "priority")
	private String priority;
	
	@Column(name = "sendeffort")
	private Boolean sendeffort;
	
	@Column(name = "startdate")
	private Date startdate;
	
	@Column(name = "dropdate")
	private Date dropdate;
	
	@Column(name = "cutoffdate")
	private Date cutoffdate;
	
	@Column(name = "holdjob")
	private Boolean holdjob;
	
	@Column(name = "holdoutput")
	private Boolean holdoutput;
	
	@Column(name = "holdupdate")
	private Boolean holdupdate;
	
	@Column(name = "holdformanualselect")
	private Boolean holdformanualselect;
	
	@Column(name = "volumegroup")
	private String volumegroup;
	
	@Column(name = "billingdate")
	private Date billingdate;
	
	@Column(name = "none")
	private Boolean none;
	
	@Column(name = "normal")
	private Boolean normal;
	
	@Column(name = "detailed")
	private Boolean detailed;
	
	@ManyToOne
	@JoinColumn(name = "order_cls_id", referencedColumnName = "oc_id")
	private OrderClass orderClass;
	
	@Column(name = "closeissue")
	private Boolean closeissue;
	
	@Column(name = "labelgroup")
	private String labelgroup;
	
	@Column(name = "keyline")
	private String keyline;
	
	@Column(name = "gracenewexpires")
	private Boolean gracenewexpires;
	
	@Column(name = "servecurrentgraces")
	private Boolean servecurrentgraces;
	
	@Column(name = "proformaorders")
	private Boolean proformaorders;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public AddProcess getAddProcessId() {
		return addProcessId;
	}

	public void setAddProcessId(AddProcess addProcessId) {
		this.addProcessId = addProcessId;
	}

	public ProcessOutput getProcessOutputId() {
		return processOutputId;
	}

	public void setProcessOutputId(ProcessOutput processOutputId) {
		this.processOutputId = processOutputId;
	}

	public String getJobdescription() {
		return jobdescription;
	}

	public void setJobdescription(String jobdescription) {
		this.jobdescription = jobdescription;
	}

	public Boolean getRunjoblocally() {
		return runjoblocally;
	}

	public void setRunjoblocally(Boolean runjoblocally) {
		this.runjoblocally = runjoblocally;
	}

	public String getJobnotes() {
		return jobnotes;
	}

	public void setJobnotes(String jobnotes) {
		this.jobnotes = jobnotes;
	}

	public String getDefaultjobqueue() {
		return defaultjobqueue;
	}

	public void setDefaultjobqueue(String defaultjobqueue) {
		this.defaultjobqueue = defaultjobqueue;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Boolean getSendeffort() {
		return sendeffort;
	}

	public void setSendeffort(Boolean sendeffort) {
		this.sendeffort = sendeffort;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getDropdate() {
		return dropdate;
	}

	public void setDropdate(Date dropdate) {
		this.dropdate = dropdate;
	}

	public Date getCutoffdate() {
		return cutoffdate;
	}

	public void setCutoffdate(Date cutoffdate) {
		this.cutoffdate = cutoffdate;
	}

	public Boolean getHoldjob() {
		return holdjob;
	}

	public void setHoldjob(Boolean holdjob) {
		this.holdjob = holdjob;
	}

	public Boolean getHoldoutput() {
		return holdoutput;
	}

	public void setHoldoutput(Boolean holdoutput) {
		this.holdoutput = holdoutput;
	}

	public Boolean getHoldupdate() {
		return holdupdate;
	}

	public void setHoldupdate(Boolean holdupdate) {
		this.holdupdate = holdupdate;
	}

	public Boolean getHoldformanualselect() {
		return holdformanualselect;
	}

	public void setHoldformanualselect(Boolean holdformanualselect) {
		this.holdformanualselect = holdformanualselect;
	}

	public String getVolumegroup() {
		return volumegroup;
	}

	public void setVolumegroup(String volumegroup) {
		this.volumegroup = volumegroup;
	}

	public Date getBillingdate() {
		return billingdate;
	}

	public void setBillingdate(Date billingdate) {
		this.billingdate = billingdate;
	}

	public Boolean getNone() {
		return none;
	}

	public void setNone(Boolean none) {
		this.none = none;
	}

	public Boolean getNormal() {
		return normal;
	}

	public void setNormal(Boolean normal) {
		this.normal = normal;
	}

	public Boolean getDetailed() {
		return detailed;
	}

	public void setDetailed(Boolean detailed) {
		this.detailed = detailed;
	}

	public OrderClass getOrderClass() {
		return orderClass;
	}

	public void setOrderClass(OrderClass orderClass) {
		this.orderClass = orderClass;
	}

	public Boolean getCloseissue() {
		return closeissue;
	}

	public void setCloseissue(Boolean closeissue) {
		this.closeissue = closeissue;
	}

	public String getLabelgroup() {
		return labelgroup;
	}

	public void setLabelgroup(String labelgroup) {
		this.labelgroup = labelgroup;
	}

	public String getKeyline() {
		return keyline;
	}

	public void setKeyline(String keyline) {
		this.keyline = keyline;
	}

	public Boolean getGracenewexpires() {
		return gracenewexpires;
	}

	public void setGracenewexpires(Boolean gracenewexpires) {
		this.gracenewexpires = gracenewexpires;
	}

	public Boolean getServecurrentgraces() {
		return servecurrentgraces;
	}

	public void setServecurrentgraces(Boolean servecurrentgraces) {
		this.servecurrentgraces = servecurrentgraces;
	}

	public Boolean getProformaorders() {
		return proformaorders;
	}

	public void setProformaorders(Boolean proformaorders) {
		this.proformaorders = proformaorders;
	}
	
	
	
	

}
