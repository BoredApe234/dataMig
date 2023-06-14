package com.mps.think.setup.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.Splits;
import com.mps.think.setup.repo.SplitsRepo;
import com.mps.think.setup.service.SplitsService;
import com.mps.think.setup.vo.SplitsVO;

@Service
public class SplitsServiceImpl implements SplitsService {
	
	@Autowired
	private SplitsRepo splitsRepo;
	
	@Autowired
	private ObjectMapper mapper;

	@Override
	public List<Splits> getAllSplits() {
		return splitsRepo.findAll();
	}

	@Override
	public Splits saveSplits(SplitsVO splits) {
		return splitsRepo.saveAndFlush(mapper.convertValue(splits , Splits.class));
	}

	@Override
	public Splits updateSplits(SplitsVO splits) {
		return splitsRepo.saveAndFlush(mapper.convertValue(splits , Splits.class));
	}

	@Override
	public Splits findbySplitsId(Integer id) {
		return splitsRepo.findById(id).get();
	}

	@Override
	public Splits deleteBySplitsId(Integer id) {
		Splits delete = findbySplitsId(id);
		splitsRepo.delete(delete);
		return delete;
	}

}
