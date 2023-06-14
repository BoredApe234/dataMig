package com.mps.think.setup.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.mps.think.setup.model.RenewalDefinition;
import com.mps.think.setup.vo.RenewalDefinitionVO;

@Service
public interface RenewalDefinitionService {
	
	public List<RenewalDefinition> getAllRenewalDefinition();
	
	public RenewalDefinition saveRenewalDefinition(RenewalDefinitionVO renewalDefinitionVO);

	public RenewalDefinition updateRenewalDefinition(RenewalDefinitionVO renewalDefinitionVO);

	public RenewalDefinition findbyRenewalDefinitionId(Integer id);
	
	public RenewalDefinition deleteByRenewalDefinitionId(Integer id);

}
