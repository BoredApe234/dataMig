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
@Table(name = "job_queue")
public class JobQueue extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "job_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer jobid;
	
	@Column(name = "ready")
	private Boolean ready;
	
	@Column(name = "running")
	private Boolean running;
	
	@Column(name = "on_hold")
	private Boolean on_hold;
	
	@Column(name = "day_end")
	private Boolean day_end;
	
	@OneToOne
	@JoinColumn(name = "submitJob_id", referencedColumnName = "id" )
	private SubmitJob submitJobId;

	public Integer getJobid() {
		return jobid;
	}

	public void setJobid(Integer jobid) {
		this.jobid = jobid;
	}

	public Boolean getReady() {
		return ready;
	}

	public void setReady(Boolean ready) {
		this.ready = ready;
	}

	public Boolean getRunning() {
		return running;
	}

	public void setRunning(Boolean running) {
		this.running = running;
	}

	public Boolean getOn_hold() {
		return on_hold;
	}

	public void setOn_hold(Boolean on_hold) {
		this.on_hold = on_hold;
	}

	public Boolean getDay_end() {
		return day_end;
	}

	public void setDay_end(Boolean day_end) {
		this.day_end = day_end;
	}

	public SubmitJob getSubmitJobId() {
		return submitJobId;
	}

	public void setSubmitJobId(SubmitJob submitJobId) {
		this.submitJobId = submitJobId;
	}
	
	

	
	
	
	
	

}
