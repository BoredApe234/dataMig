package com.mps.think.setup.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.Repeating;
import com.mps.think.setup.repo.RepeatingRepo;
import com.mps.think.setup.service.RepeatingService;
import com.mps.think.setup.vo.RepeatingVO;

@Service
public class RepeatingServiceimpl implements RepeatingService {
	
	@Autowired
	private RepeatingRepo repeatingRepo;
	
	@Autowired
	private ObjectMapper mapper;

	@Override
	public List<Repeating> getAllRepeating() {
		return repeatingRepo.findAll();
	}

	@Override
	public Repeating saveRepeating(RepeatingVO repeating) {
		return repeatingRepo.saveAndFlush(mapper.convertValue(repeating, Repeating.class));
	}

	@Override
	public Repeating updateRepeating(RepeatingVO repeating) {
		return repeatingRepo.saveAndFlush(mapper.convertValue(repeating, Repeating.class));
	}

	@Override
	public Repeating findbyRepeatingId(Integer id) {
		return repeatingRepo.findById(id).get();
	}

	@Override
	public Repeating deleteByRepeatingId(Integer id) {
		Repeating delete = findbyRepeatingId(id);
		repeatingRepo.delete(delete);
		return delete;
	}

}
