package com.mps.think.setup.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.mps.think.setup.model.Repeating;
import com.mps.think.setup.vo.RepeatingVO;


@Service
public interface RepeatingService {
	
	public List<Repeating> getAllRepeating();
	
	public Repeating saveRepeating(RepeatingVO repeating);

	public Repeating updateRepeating(RepeatingVO repeating);

	public Repeating findbyRepeatingId(Integer id);
	
	public Repeating deleteByRepeatingId(Integer id);

}
