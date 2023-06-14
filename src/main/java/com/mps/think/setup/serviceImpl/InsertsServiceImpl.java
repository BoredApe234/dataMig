package com.mps.think.setup.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.Inserts;
import com.mps.think.setup.repo.InsertRepo;
import com.mps.think.setup.service.InsertService;
import com.mps.think.setup.vo.InsertsVO;

@Service
public class InsertsServiceImpl implements InsertService {
	
	@Autowired
	private InsertRepo insertRepo;
	
	@Autowired
	private ObjectMapper mapper;

	@Override
	public List<Inserts> getAllInserts() {
		return insertRepo.findAll();
	}

	@Override
	public Inserts saveInserts(InsertsVO inserts) {
		return insertRepo.saveAndFlush(mapper.convertValue(inserts, Inserts.class) );
	}

	@Override
	public Inserts updateInserts(InsertsVO inserts) {
		return insertRepo.saveAndFlush(mapper.convertValue(inserts, Inserts.class) );
	}

	@Override
	public Inserts findbyInsertsId(Integer id) {
		return insertRepo.findById(id).get();
	}

	@Override
	public Inserts deleteByInsertsId(Integer id) {
		Inserts delete = findbyInsertsId(id);
		insertRepo.delete(delete);
		return delete;
	}

}
