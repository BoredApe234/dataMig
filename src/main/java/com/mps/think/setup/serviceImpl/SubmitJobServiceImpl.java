package com.mps.think.setup.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.SubmitJob;
import com.mps.think.setup.repo.SubmitJobRepo;
import com.mps.think.setup.service.SubmitJobService;
import com.mps.think.setup.vo.SubmitJobVO;

@Service
public class SubmitJobServiceImpl implements SubmitJobService {
	
	@Autowired
	private SubmitJobRepo submitJobRepo;

	@Override
	public List<SubmitJob> getAllSubmitJob() {
		return submitJobRepo.findAll();
	}

	@Override
	public SubmitJobVO saveSubmitJob(SubmitJobVO submitJob) {
		ObjectMapper mapper = new ObjectMapper();
		SubmitJob newSubmitJob = mapper.convertValue(submitJob, SubmitJob.class);
		SubmitJob data=submitJobRepo.saveAndFlush(newSubmitJob);
		submitJob.setId(data.getId());
		return submitJob;
	}

	@Override
	public SubmitJobVO updateSubmitJob(SubmitJobVO submitJob) {
		ObjectMapper mapper = new ObjectMapper();
		SubmitJob newSubmitJob = mapper.convertValue(submitJob, SubmitJob.class);
		SubmitJob data=submitJobRepo.saveAndFlush(newSubmitJob);
		submitJob.setId(data.getId());
		return submitJob;
	}

	@Override
	public SubmitJob findbySubmitJobId(Integer submitJobId) {
		Optional<SubmitJob> cr = submitJobRepo.findById(submitJobId);
		return cr.get();
	}

	@Override
	public SubmitJob deleteBySubmitJobId(Integer submitJobId) {
		SubmitJob delete = findbySubmitJobId(submitJobId);
		submitJobRepo.delete(delete);
		return delete;
	}

}
