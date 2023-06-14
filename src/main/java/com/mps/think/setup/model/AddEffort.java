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
@Table(name="efforts")
public class AddEffort extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="effort")
	private String effort;
	
	@Column(name="method")
	private String method;
	
	@Column(name="noofdays")
	private String noofdays;
	
	@Column(name="efforttype")
	private String efforttype;
	
	@Column(name="sendto")
	private String sendto;
	
	@Column(name="pricing")
	private String pricing;
	
	@OneToOne
	@JoinColumn(name = "ov_id", referencedColumnName = "id" )
	private OutputValue ovId;
	
	@Column(name="attachments")
	private String attachments;
	
	@Column(name="message")
	private String message;
	
	@OneToOne
	@JoinColumn(name = "rd_id", referencedColumnName = "id" )
	private RenewalDefinition rdid;
	
	@Column(name="renewaldefinition")
	private String renewaldefinition;

	@Column(name="renewaldefinitiontestseq")
	private String renewaldefinitiontestseq;
	
	@Column(name="suppressemail")
	private Boolean suppressemail;
	
	@Column(name="testinginprogress")
	private Boolean testinginprogress;
	
	@Column(name="description")
	private String description;
	
	@Column(name="nth")
	private Integer nth;
	
	@Column(name="showallprocesses")
	private Boolean showallprocesses;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEffort() {
		return effort;
	}

	public void setEffort(String effort) {
		this.effort = effort;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getNoofdays() {
		return noofdays;
	}

	public void setNoofdays(String noofdays) {
		this.noofdays = noofdays;
	}

	public String getEfforttype() {
		return efforttype;
	}

	public void setEfforttype(String efforttype) {
		this.efforttype = efforttype;
	}

	public String getSendto() {
		return sendto;
	}

	public void setSendto(String sendto) {
		this.sendto = sendto;
	}

	public String getPricing() {
		return pricing;
	}

	public void setPricing(String pricing) {
		this.pricing = pricing;
	}

	public OutputValue getOvId() {
		return ovId;
	}

	public void setOvId(OutputValue ovId) {
		this.ovId = ovId;
	}

	public String getAttachments() {
		return attachments;
	}

	public void setAttachments(String attachments) {
		this.attachments = attachments;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public RenewalDefinition getRdid() {
		return rdid;
	}

	public void setRdid(RenewalDefinition rdid) {
		this.rdid = rdid;
	}

	public String getRenewaldefinition() {
		return renewaldefinition;
	}

	public void setRenewaldefinition(String renewaldefinition) {
		this.renewaldefinition = renewaldefinition;
	}

	public String getRenewaldefinitiontestseq() {
		return renewaldefinitiontestseq;
	}

	public void setRenewaldefinitiontestseq(String renewaldefinitiontestseq) {
		this.renewaldefinitiontestseq = renewaldefinitiontestseq;
	}

	public Boolean getSuppressemail() {
		return suppressemail;
	}

	public void setSuppressemail(Boolean suppressemail) {
		this.suppressemail = suppressemail;
	}

	public Boolean getTestinginprogress() {
		return testinginprogress;
	}

	public void setTestinginprogress(Boolean testinginprogress) {
		this.testinginprogress = testinginprogress;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getNth() {
		return nth;
	}

	public void setNth(Integer nth) {
		this.nth = nth;
	}

	public Boolean getShowallprocesses() {
		return showallprocesses;
	}

	public void setShowallprocesses(Boolean showallprocesses) {
		this.showallprocesses = showallprocesses;
	}

	@Override
	public String toString() {
		return "AddEffort [id=" + id + ", effort=" + effort + ", method=" + method + ", noofdays=" + noofdays
				+ ", efforttype=" + efforttype + ", sendto=" + sendto + ", pricing=" + pricing + ", ovId=" + ovId
				+ ", attachments=" + attachments + ", message=" + message + ", rdid=" + rdid + ", renewaldefinition="
				+ renewaldefinition + ", renewaldefinitiontestseq=" + renewaldefinitiontestseq + ", suppressemail="
				+ suppressemail + ", testinginprogress=" + testinginprogress + ", description=" + description + ", nth="
				+ nth + ", showallprocesses=" + showallprocesses + "]";
	}
	


}
