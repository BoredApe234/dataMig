package com.mps.think.setup.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.CustomerDetails;
import com.mps.think.setup.model.SourceFormat;
import com.mps.think.setup.repo.SourceFormatRepo;
import com.mps.think.setup.service.SourceFormatService;
import com.mps.think.setup.vo.SourceFormatVo;
@Service
public class SourceFormatServiceImpl implements SourceFormatService {

	@Autowired
	SourceFormatRepo sourceFormatRepo;
	
	@Override
	public List<SourceFormat> findAllSourceFormat() {
		return sourceFormatRepo.findAll();
	}

	@Override
	public SourceFormatVo saveSourceFormat(SourceFormatVo sourceFormatVo) {
		ObjectMapper mapper = new ObjectMapper();
		SourceFormat sf = mapper.convertValue(sourceFormatVo, SourceFormat.class);
		sourceFormatRepo.saveAndFlush(sf);
		return sourceFormatVo;
	}

	@Override
	public SourceFormatVo updateSourceFormat(SourceFormatVo sourceFormatVo) {
		ObjectMapper mapper = new ObjectMapper();
		SourceFormat sf = mapper.convertValue(sourceFormatVo, SourceFormat.class);
		sourceFormatRepo.saveAndFlush(sf);
		return sourceFormatVo;
	}

	@Override
	public SourceFormat findbySourceFormatId(Integer SourceFormatId) {
		return sourceFormatRepo.findById(SourceFormatId).get();
	}

	@Override
	public SourceFormat deleteBySourceFormatId(Integer id) {
		SourceFormat delete = findbySourceFormatId(id);
		sourceFormatRepo.delete(delete);
		return delete;
	}

	@Override
	public List<SourceFormat> getAllSourceFormatForPublisher(Integer pubId) {
		return sourceFormatRepo.findBypubIdId(pubId);
	}

}
