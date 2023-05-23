package com.mps.think.setup.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.AddProcess;
import com.mps.think.setup.repo.AddProcessRepo;
import com.mps.think.setup.service.AddProcessService;
import com.mps.think.setup.vo.AddProcessVO;

@Service
public class AddProcessServiceImpl implements AddProcessService {
	
	@Autowired
	private AddProcessRepo addProcessRepo;

	@Override
	public List<AddProcess> getAllProcess() {
		return addProcessRepo.findAll();
	}

	@Override
	public AddProcessVO saveProcess(AddProcessVO process) {
		ObjectMapper mapper = new ObjectMapper();
		AddProcess newAddProcess = mapper.convertValue(process, AddProcess.class);
		AddProcess data=addProcessRepo.saveAndFlush(newAddProcess);
		process.setProcess_id(data.getProcess_id());
		return process;
	}

	@Override
	public AddProcessVO updateProcess(AddProcessVO process) {
		ObjectMapper mapper = new ObjectMapper();
		AddProcess updateAddProcess = mapper.convertValue(process, AddProcess.class);
		AddProcess data=addProcessRepo.saveAndFlush(updateAddProcess);
		process.setProcess_id(data.getProcess_id());
		return process;
	}

	@Override
	public AddProcess findbyProcessId(Integer process_id) {
		Optional<AddProcess> cr = addProcessRepo.findById(process_id);
		return cr.get();
	}

	@Override
	public AddProcess deleteByProcessId(Integer process_id) {
		AddProcess delete = findbyProcessId(process_id);
		addProcessRepo.delete(delete);
		return delete;
	}
	
	@Override
	public List<AddProcess> findAllAddProcessByPId(Integer pid) {
		return addProcessRepo.findByprocesstypeidPid(pid);
	}

}
