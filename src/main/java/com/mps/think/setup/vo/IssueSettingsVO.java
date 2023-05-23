package com.mps.think.setup.vo;

import javax.persistence.Column;

import com.mps.think.setup.model.OrderClass;

public class IssueSettingsVO {
	
	private Integer id;

//	Issue Date Generation
	private Integer numberOfIssue;

	private String frequencyOfGeneration;

	private String issuesAppearonEvery;
	
	private String volumeCaption;
	
	private String volumeFormat;
	
	private String changeDate;
	
	private String issueCaption;
	
	private String issueFormat;
	
	private String issuesOrVolume;
	
	private String numberOfIssues;
	
	private String VolumeOfIssues;
	
	private String timePeriod;
	
	private Integer backIssues;
	
	private Integer BeforeAfterCurrentDate;

	// order class mapping will be there
	private OrderClass orderClassId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumberOfIssue() {
		return numberOfIssue;
	}

	public void setNumberOfIssue(Integer numberOfIssue) {
		this.numberOfIssue = numberOfIssue;
	}

	public String getFrequencyOfGeneration() {
		return frequencyOfGeneration;
	}

	public void setFrequencyOfGeneration(String frequencyOfGeneration) {
		this.frequencyOfGeneration = frequencyOfGeneration;
	}

	public String getIssuesAppearonEvery() {
		return issuesAppearonEvery;
	}

	public void setIssuesAppearonEvery(String issuesAppearonEvery) {
		this.issuesAppearonEvery = issuesAppearonEvery;
	}

	public String getVolumeCaption() {
		return volumeCaption;
	}

	public void setVolumeCaption(String volumeCaption) {
		this.volumeCaption = volumeCaption;
	}

	public String getVolumeFormat() {
		return volumeFormat;
	}

	public void setVolumeFormat(String volumeFormat) {
		this.volumeFormat = volumeFormat;
	}

	public String getChangeDate() {
		return changeDate;
	}

	public void setChangeDate(String changeDate) {
		this.changeDate = changeDate;
	}

	public String getIssueCaption() {
		return issueCaption;
	}

	public void setIssueCaption(String issueCaption) {
		this.issueCaption = issueCaption;
	}

	public String getIssueFormat() {
		return issueFormat;
	}

	public void setIssueFormat(String issueFormat) {
		this.issueFormat = issueFormat;
	}

	public String getIssuesOrVolume() {
		return issuesOrVolume;
	}

	public void setIssuesOrVolume(String issuesOrVolume) {
		this.issuesOrVolume = issuesOrVolume;
	}

	public String getNumberOfIssues() {
		return numberOfIssues;
	}

	public void setNumberOfIssues(String numberOfIssues) {
		this.numberOfIssues = numberOfIssues;
	}

	public String getVolumeOfIssues() {
		return VolumeOfIssues;
	}

	public void setVolumeOfIssues(String volumeOfIssues) {
		VolumeOfIssues = volumeOfIssues;
	}

	public String getTimePeriod() {
		return timePeriod;
	}

	public void setTimePeriod(String timePeriod) {
		this.timePeriod = timePeriod;
	}

	public Integer getBackIssues() {
		return backIssues;
	}

	public void setBackIssues(Integer backIssues) {
		this.backIssues = backIssues;
	}

	public Integer getBeforeAfterCurrentDate() {
		return BeforeAfterCurrentDate;
	}

	public void setBeforeAfterCurrentDate(Integer beforeAfterCurrentDate) {
		BeforeAfterCurrentDate = beforeAfterCurrentDate;
	}

	public OrderClass getOrderClassId() {
		return orderClassId;
	}

	public void setOrderClassId(OrderClass orderClassId) {
		this.orderClassId = orderClassId;
	}

	@Override
	public String toString() {
		return "IssueSettingsVO [id=" + id + ", numberOfIssue=" + numberOfIssue + ", frequencyOfGeneration="
				+ frequencyOfGeneration + ", issuesAppearonEvery=" + issuesAppearonEvery + ", volumeCaption="
				+ volumeCaption + ", volumeFormat=" + volumeFormat + ", changeDate=" + changeDate + ", issueCaption="
				+ issueCaption + ", issueFormat=" + issueFormat + ", issuesOrVolume=" + issuesOrVolume
				+ ", numberOfIssues=" + numberOfIssues + ", VolumeOfIssues=" + VolumeOfIssues + ", timePeriod="
				+ timePeriod + ", backIssues=" + backIssues + ", BeforeAfterCurrentDate=" + BeforeAfterCurrentDate
				+ ", orderClassId=" + orderClassId + "]";
	}

}
