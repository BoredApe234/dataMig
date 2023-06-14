package com.mps.think.setup.serviceImpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.RenewalDefinition;
import com.mps.think.setup.repo.RenewalDefinitionRepo;
import com.mps.think.setup.service.RenewalDefinitionService;
import com.mps.think.setup.vo.RenewalDefinitionVO;

@Service
public class RenewalDefinitionServiceImpl implements RenewalDefinitionService {
	
	@Autowired
	private RenewalDefinitionRepo renewalDefinitionRepo;
	
	@Autowired
	private ObjectMapper mapper;

	@Override
	public List<RenewalDefinition> getAllRenewalDefinition() {
		return renewalDefinitionRepo.findAll();
	}

	@Override
	public RenewalDefinition saveRenewalDefinition(RenewalDefinitionVO renewalDefinitionVO) {
		return renewalDefinitionRepo.saveAndFlush(mapper.convertValue(renewalDefinitionVO, RenewalDefinition.class));
	}

	@Override
	public RenewalDefinition updateRenewalDefinition(RenewalDefinitionVO renewalDefinitionVO) {
		 return renewalDefinitionRepo.saveAndFlush(mapper.convertValue(renewalDefinitionVO, RenewalDefinition.class));
	}

	@Override
	public RenewalDefinition findbyRenewalDefinitionId(Integer id) {
		return renewalDefinitionRepo.findById(id).get();
	}

	@Override
	public RenewalDefinition deleteByRenewalDefinitionId(Integer id) {
		RenewalDefinition delete = findbyRenewalDefinitionId(id);
		renewalDefinitionRepo.delete(delete);
		return delete;
	}
}
