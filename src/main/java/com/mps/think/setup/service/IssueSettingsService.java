package com.mps.think.setup.service;

import java.util.List;

import com.mps.think.setup.model.IssueGeneration;
import com.mps.think.setup.model.IssueSettings;
import com.mps.think.setup.vo.IssueSettingsVO;

public interface IssueSettingsService {
	public List<IssueSettings> findAllIssueSetting();

	public IssueSettingsVO saveIssueSetting(IssueSettingsVO issueSettingsVO);

	public IssueSettingsVO updateIssueSetting(IssueSettingsVO issueSettingsVO);

	public IssueSettings findbyIssueSettingId(Integer issueSettingId);
	
	public List<IssueSettings> getAllIssueSettingsForPublisher(Integer pubId);

}
