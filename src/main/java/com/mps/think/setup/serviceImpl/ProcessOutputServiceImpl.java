package com.mps.think.setup.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.ProcessOutput;
import com.mps.think.setup.repo.ProcessOutputRepo;
import com.mps.think.setup.service.ProcessOutputService;
import com.mps.think.setup.vo.ProcessOutputVO;

@Service
public class ProcessOutputServiceImpl implements ProcessOutputService {
	
	@Autowired
	private ProcessOutputRepo processOutputRepo;

	@Override
	public List<ProcessOutput> getAllProcessOutput() {
		return processOutputRepo.findAll();
	}

	@Override
	public ProcessOutputVO saveProcessOutput(ProcessOutputVO processoutput) {
		ObjectMapper mapper = new ObjectMapper();
		ProcessOutput newProcessOutput = mapper.convertValue(processoutput, ProcessOutput.class);
		ProcessOutput data=processOutputRepo.saveAndFlush(newProcessOutput);
		processoutput.setOutput_id(data.getOutput_id());
		return processoutput;
	}

	@Override
	public ProcessOutputVO updateProcessOutput(ProcessOutputVO processoutput) {
		ObjectMapper mapper = new ObjectMapper();
		ProcessOutput updateProcessOutput = mapper.convertValue(processoutput, ProcessOutput.class);
		ProcessOutput data=processOutputRepo.saveAndFlush(updateProcessOutput);
		processoutput.setOutput_id(data.getOutput_id());
		return processoutput;
	}

	@Override
	public ProcessOutput findbyProcessOutputId(Integer output_id) {
		Optional<ProcessOutput> cr = processOutputRepo.findById(output_id);
		return cr.get();
	}

	@Override
	public ProcessOutput deleteByProcessOutputId(Integer output_id) {
		ProcessOutput delete = findbyProcessOutputId(output_id);
		processOutputRepo.delete(delete);
		return delete;
	}

}
