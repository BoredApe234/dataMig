package com.mps.think.setup.service;
import java.util.List;
import org.springframework.stereotype.Service;

import com.mps.think.setup.model.Jurisdictions;
import com.mps.think.setup.model.Statecode;
import com.mps.think.setup.vo.StatecodeVO;

@Service
public interface StatecodeService {
	
	public List<Statecode> getAllStatecode();
	
	public Statecode saveStatecode(StatecodeVO statecode);

	public Statecode updateStatecode(StatecodeVO statecode);

	public Statecode findbyStatecodeId(Integer id);
	
	public Statecode deleteByStatecodeId(Integer id);
	
	List<Statecode> findAllStatecodeForCountry(String country);
	
	

}
