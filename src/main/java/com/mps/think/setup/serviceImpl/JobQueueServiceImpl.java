package com.mps.think.setup.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.JobQueue;
import com.mps.think.setup.repo.JobQueueRepo;
import com.mps.think.setup.service.JobQueueService;
import com.mps.think.setup.vo.JobQueueVO;

@Service
public class JobQueueServiceImpl implements JobQueueService{
	
	@Autowired
	private JobQueueRepo jobqueueRepo;

	@Override
	public List<JobQueue> findAllJobQueue() {
		return jobqueueRepo.findAll();
	}

	@Override
	public JobQueueVO saveJobQueue(JobQueueVO jobqueue) {
		ObjectMapper mapper = new ObjectMapper();
		JobQueue newJobQueue = mapper.convertValue(jobqueue, JobQueue.class);
		JobQueue data=jobqueueRepo.saveAndFlush(newJobQueue);
		jobqueue.setJobid(data.getJobid());
		return jobqueue;
	}

	@Override
	public JobQueueVO updateJobQueue(JobQueueVO jobqueue) {
		ObjectMapper mapper = new ObjectMapper();
		JobQueue updateJobQueue = mapper.convertValue(jobqueue, JobQueue.class);
		JobQueue data=jobqueueRepo.saveAndFlush(updateJobQueue);
		jobqueue.setJobid(data.getJobid());
		return jobqueue;
	}

	@Override
	public JobQueue findbyId(Integer id) {
		 Optional<JobQueue> cr = jobqueueRepo.findById(id);
			return cr.get();
	}

	@Override
	public JobQueue deleteById(Integer id) {
		JobQueue delete = findbyId(id);
		jobqueueRepo.delete(delete);
		return delete;
	}

	

}
