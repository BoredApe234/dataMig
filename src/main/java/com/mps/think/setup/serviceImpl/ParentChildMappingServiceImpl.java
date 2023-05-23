package com.mps.think.setup.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.ParentChildMapping;
import com.mps.think.setup.repo.ParentChildMappingRepo;
import com.mps.think.setup.service.ParentChildMappingService;
import com.mps.think.setup.vo.ParentChildMappingVO;
@Service
public class ParentChildMappingServiceImpl implements ParentChildMappingService {

	@Autowired
	ParentChildMappingRepo parentchildMappingRepo;

	@Override
	public List<ParentChildMapping> findAllParentChild() {
		return parentchildMappingRepo.findAll();
	}

	@Override
	public ParentChildMappingVO saveAuxVParentChild(ParentChildMappingVO auxVariableVO) {
		ObjectMapper mapper = new ObjectMapper();
		ParentChildMapping parentChild = mapper.convertValue(auxVariableVO, ParentChildMapping.class);
		if(auxVariableVO.getChildId().getOcId()==0){
			parentChild.setChildId(null);
		}
		ParentChildMapping data = parentchildMappingRepo.saveAndFlush(parentChild);
		auxVariableVO.setId(data.getId());
		return auxVariableVO;
	}

	@Override
	public ParentChildMappingVO updateAuxParentChild(ParentChildMappingVO auxVariableVO) {
		ObjectMapper mapper = new ObjectMapper();
		ParentChildMapping parentChild = mapper.convertValue(auxVariableVO, ParentChildMapping.class);
		if(auxVariableVO.getChildId().getOcId()==0){
			parentChild.setChildId(null);
		}
		parentchildMappingRepo.saveAndFlush(parentChild);
		return auxVariableVO;
	}

	@Override
	public ParentChildMapping findbyParentChildMappingId(Integer id) {

		return parentchildMappingRepo.findById(id).get();
	}

	@Override
	public List<ParentChildMapping> findAllParentChildByPublisherId(Integer pubId) {
		return parentchildMappingRepo.findByParentIdPubIdId(pubId);
	}

}
