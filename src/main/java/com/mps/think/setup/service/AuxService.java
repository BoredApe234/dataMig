package com.mps.think.setup.service;

import java.util.List;

import com.mps.think.setup.model.AuxVariable;
import com.mps.think.setup.vo.AuxVariableVO;

public interface AuxService {

	public List<AuxVariable> findAllAuxVariable();

	public AuxVariableVO saveAuxVariable(AuxVariableVO auxVariableVO);

	public AuxVariableVO updateAuxVariable(AuxVariableVO auxVariableVO);

	public AuxVariable findbyAuxId(Integer id);
	
	public List<AuxVariable> getAllAuxForPublisher(Integer pubId);
	
	public AuxVariable deleteByAuxVariableId(Integer auxId);

}
