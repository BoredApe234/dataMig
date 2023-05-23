package com.mps.think.setup.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.mps.think.setup.model.ProcessType;
import com.mps.think.setup.vo.ProcessTypeVO;

@Service
public interface ProcessTypeService {
	
	public List<ProcessType> getAllProcessType();

	public ProcessTypeVO saveProcessType(ProcessTypeVO processType);

	public ProcessTypeVO updateProcessType(ProcessTypeVO processType);

	public ProcessType findbyProcessTypeId(Integer p_Id);
	
	public ProcessType deleteByProcessTypeId(Integer p_Id);
	
	

}
