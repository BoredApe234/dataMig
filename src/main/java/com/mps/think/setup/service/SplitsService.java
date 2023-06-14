package com.mps.think.setup.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.mps.think.setup.model.Splits;
import com.mps.think.setup.vo.SplitsVO;

@Service
public interface SplitsService {
	
	public List<Splits> getAllSplits();
	
	public Splits saveSplits(SplitsVO splits);

	public Splits updateSplits(SplitsVO splits);

	public Splits findbySplitsId(Integer id);
	
	public Splits deleteBySplitsId(Integer id);

}
