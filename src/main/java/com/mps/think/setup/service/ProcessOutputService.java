package com.mps.think.setup.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.mps.think.setup.model.ProcessOutput;
import com.mps.think.setup.vo.ProcessOutputVO;

@Service
public interface ProcessOutputService {
	
	public List<ProcessOutput> getAllProcessOutput();
	
	public ProcessOutputVO saveProcessOutput(ProcessOutputVO processoutput);

	public ProcessOutputVO updateProcessOutput(ProcessOutputVO processoutput);

	public ProcessOutput findbyProcessOutputId(Integer output_id);
	
	public ProcessOutput deleteByProcessOutputId(Integer output_id);

}
