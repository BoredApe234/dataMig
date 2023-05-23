package com.mps.think.setup.vo;

import com.mps.think.setup.model.SubmitJob;

public class JobQueueVO {
	
    private Integer jobid;
	private Boolean ready;
	private Boolean running;
	private Boolean on_hold;
	private Boolean day_end;
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
