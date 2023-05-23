package com.mps.think.setup.serviceImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.ProcessType;
import com.mps.think.setup.repo.ProcessTypeRepo;
import com.mps.think.setup.service.ProcessTypeService;
import com.mps.think.setup.vo.ProcessTypeVO;

@Service
public class ProcessTypeServiceImpl  implements ProcessTypeService{
	
	@Autowired
	private ProcessTypeRepo processTypeRepo;

	@Override
	public List<ProcessType> getAllProcessType() {
		return processTypeRepo.findAll();
	}

	@Override
	public ProcessTypeVO saveProcessType(ProcessTypeVO processType) {
		ObjectMapper mapper = new ObjectMapper();
		ProcessType newProcessType = mapper.convertValue(processType, ProcessType.class);
		ProcessType data=processTypeRepo.saveAndFlush(newProcessType);
		processType.setPid(data.getPid());
		return processType;
	}

	@Override
	public ProcessTypeVO updateProcessType(ProcessTypeVO processType) {
		ObjectMapper mapper = new ObjectMapper();
		ProcessType updateProcessType = mapper.convertValue(processType, ProcessType.class);
		ProcessType data=processTypeRepo.saveAndFlush(updateProcessType);
		processType.setPid(data.getPid());
		return processType;
	}

	@Override
	public ProcessType findbyProcessTypeId(Integer p_Id) {
		Optional<ProcessType> cr = processTypeRepo.findById(p_Id);
		return cr.get();
	}

	@Override
	public ProcessType deleteByProcessTypeId(Integer p_Id) {
		ProcessType delete = findbyProcessTypeId(p_Id);
		processTypeRepo.delete(delete);
		return delete;
	}

}
