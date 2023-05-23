package com.mps.think.setup.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mps.think.setup.model.AddProcess;
import com.mps.think.setup.vo.AddProcessVO;


@Service
public interface AddProcessService {
	
	public List<AddProcess> getAllProcess();
	
	public AddProcessVO saveProcess(AddProcessVO process);

	public AddProcessVO updateProcess(AddProcessVO process);

	public AddProcess findbyProcessId(Integer process_id);
	
	public AddProcess deleteByProcessId(Integer process_id);
	
	public List<AddProcess> findAllAddProcessByPId(Integer pId);

}
