package com.mps.think.setup.serviceImpl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.Statecode;
import com.mps.think.setup.repo.StatecodeRepo;
import com.mps.think.setup.service.StatecodeService;
import com.mps.think.setup.vo.StatecodeVO;
import com.mps.think.setup.vo.EnumModelVO.Pricing;

@Service
public class StatecodeServiceImpl implements StatecodeService {
	
	
	@Autowired
	private StatecodeRepo statecodeRepo;
	
	@Autowired
	private ObjectMapper mapper;

	@Override
	public List<Statecode> getAllStatecode() {
		return statecodeRepo.findAll();
	}

	@Override
	public Statecode saveStatecode(StatecodeVO statecode) {
		return statecodeRepo.saveAndFlush(mapper.convertValue(statecode, Statecode.class));
	}

	@Override
	public Statecode updateStatecode(StatecodeVO statecode) {
		return statecodeRepo.saveAndFlush(mapper.convertValue(statecode, Statecode.class));
	}

	@Override
	public Statecode findbyStatecodeId(Integer id) {
		return statecodeRepo.findById(id).get();
	}

	@Override
	public Statecode deleteByStatecodeId(Integer id) {
		Statecode delete = findbyStatecodeId(id);
		statecodeRepo.delete(delete);
		return delete;
	}
	


	@Override
	public List<Statecode> findAllStatecodeForCountry(String country) {
		return statecodeRepo.findByCountry(country);
	}

}
