package com.mps.think.setup.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mps.think.setup.model.JobQueue;
import com.mps.think.setup.vo.JobQueueVO;


@Service
public interface JobQueueService {
	
	public List<JobQueue> findAllJobQueue();

	public JobQueueVO saveJobQueue(JobQueueVO jobqueue);

	public JobQueueVO updateJobQueue(JobQueueVO jobqueue);

	public JobQueue findbyId(Integer id);
	
	public JobQueue deleteById(Integer id);

}
