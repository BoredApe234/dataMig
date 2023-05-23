package com.mps.think.setup.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.IssueSettings;
import com.mps.think.setup.repo.IssueSettingsRepo;
import com.mps.think.setup.service.IssueSettingsService;
import com.mps.think.setup.vo.IssueSettingsVO;
@Service
public class IssueSettingsServiceImpl implements IssueSettingsService{
	
	@Autowired
	IssueSettingsRepo issueSettingsRepo;

	@Override
	public List<IssueSettings> findAllIssueSetting() {
		return issueSettingsRepo.findAll();
	}

	@Override
	public IssueSettingsVO saveIssueSetting(IssueSettingsVO issueSettingsVO) {
		
		ObjectMapper mapper = new ObjectMapper();
		IssueSettings issueSettings = mapper.convertValue(issueSettingsVO, IssueSettings.class);
		IssueSettings data=issueSettingsRepo.saveAndFlush(issueSettings);
		issueSettingsVO.setId(data.getId());
		return issueSettingsVO;
	}

	@Override
	public IssueSettingsVO updateIssueSetting(IssueSettingsVO issueSettingsVO) {
		ObjectMapper mapper = new ObjectMapper();
		IssueSettings issueSettings = mapper.convertValue(issueSettingsVO, IssueSettings.class);
		issueSettingsRepo.saveAndFlush(issueSettings);
		return issueSettingsVO;
	}

	@Override
	public IssueSettings findbyIssueSettingId(Integer IssueSettingId) {
		Optional<IssueSettings> data=issueSettingsRepo.findById(IssueSettingId);
		return data.get();
	}

	@Override
	public List<IssueSettings> getAllIssueSettingsForPublisher(Integer pubId) {
		return issueSettingsRepo.findByOrderClassIdPubIdId(pubId);
	}

	
}
