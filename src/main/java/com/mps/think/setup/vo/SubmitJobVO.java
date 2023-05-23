package com.mps.think.setup.vo;

import java.util.Date;

import com.mps.think.setup.model.AddProcess;
import com.mps.think.setup.model.OrderClass;
import com.mps.think.setup.model.ProcessOutput;

public class SubmitJobVO {
	
    private Integer id;
	
	private AddProcess addProcessId;

	private ProcessOutput processOutputId;

	private String jobdescription;
	
	private Boolean runjoblocally;
	
	private String jobnotes;

	private String defaultjobqueue;
	
	private String priority;
	
	private Boolean sendeffort;
	
	private Date startdate;
	
	private Date dropdate;
	
	private Date cutoffdate;

	private Boolean holdjob;
	
	private Boolean holdoutput;
	
	private Boolean holdupdate;
	
	private Boolean holdformanualselect;

	private String volumegroup;
	
	private Date billingdate;

	private Boolean none;
	
	private Boolean normal;
	
	private Boolean detailed;
	
	private OrderClass orderClass;
	
	private Boolean closeissue;
	
	private String labelgroup;

	private String keyline;

	private Boolean gracenewexpires;

	private Boolean servecurrentgraces;

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
