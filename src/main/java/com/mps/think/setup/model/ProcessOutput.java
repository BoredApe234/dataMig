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
@Table(name = "process_output")
public class ProcessOutput extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "output_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer output_id;
	
	@OneToOne
	@JoinColumn(name = "addProcess_id", referencedColumnName = "process_id" )
	private AddProcess addProcessId;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "output")
	private String output;
	
	@Column(name = "mode")
	private String mode;
	
	@Column(name = "outputfilename")
	private String outputfilename;
	
	@Column(name = "apendjobid")
	private Boolean apendjobId;
	
	@Column(name = "outputfileformat")
	private String outputfileformat;
	
	@Column(name = "installmentplan")
	private String installmentplan;
	
	@Column(name = "def")
	private String def;
	
	@Column(name = "test")
	private String test;
	
	@Column(name = "effort")
	private String effort;
	
	@Column(name = "auditreport")
	private String auditreport;
	
	@Column(name = "parameter_value")
	private String parametervalue;

	public Integer getOutput_id() {
		return output_id;
	}

	public void setOutput_id(Integer output_id) {
		this.output_id = output_id;
	}

	public AddProcess getAddProcessId() {
		return addProcessId;
	}

	public void setAddProcessId(AddProcess addProcessId) {
		this.addProcessId = addProcessId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getOutputfilename() {
		return outputfilename;
	}

	public void setOutputfilename(String outputfilename) {
		this.outputfilename = outputfilename;
	}

	public Boolean getApendjobId() {
		return apendjobId;
	}

	public void setApendjobId(Boolean apendjobId) {
		this.apendjobId = apendjobId;
	}

	public String getOutputfileformat() {
		return outputfileformat;
	}

	public void setOutputfileformat(String outputfileformat) {
		this.outputfileformat = outputfileformat;
	}

	public String getInstallmentplan() {
		return installmentplan;
	}

	public void setInstallmentplan(String installmentplan) {
		this.installmentplan = installmentplan;
	}

	public String getDef() {
		return def;
	}

	public void setDef(String def) {
		this.def = def;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public String getEffort() {
		return effort;
	}

	public void setEffort(String effort) {
		this.effort = effort;
	}

	public String getAuditreport() {
		return auditreport;
	}

	public void setAuditreport(String auditreport) {
		this.auditreport = auditreport;
	}

	public String getParametervalue() {
		return parametervalue;
	}

	public void setParametervalue(String parametervalue) {
		this.parametervalue = parametervalue;
	}
	
	

	
	
	
	
	

}
