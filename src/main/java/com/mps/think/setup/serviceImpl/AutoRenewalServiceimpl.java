package com.mps.think.setup.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.AutoRenewal;
import com.mps.think.setup.repo.AutoRenewalRepo;
import com.mps.think.setup.service.AutoRenewalService;
import com.mps.think.setup.vo.AutoRenewalVO;

@Service
public class AutoRenewalServiceimpl implements AutoRenewalService{
	
	@Autowired
	AutoRenewalRepo autoRenewalRepo;
	
	@Autowired
	ObjectMapper mapper;

	@Override
	public List<AutoRenewal> getAllAutoRenewal() {
		return autoRenewalRepo.findAll();
	}

	@Override
	public AutoRenewal saveAutoRenewal(AutoRenewalVO autoRenewal) {
		return autoRenewalRepo.saveAndFlush(mapper.convertValue(autoRenewal, AutoRenewal.class) );
	}

	@Override
	public AutoRenewal updateAutoRenewal(AutoRenewalVO autoRenewal) {
		return autoRenewalRepo.saveAndFlush(mapper.convertValue(autoRenewal, AutoRenewal.class) );
	}

	@Override
	public AutoRenewal findbyAutoRenewalId(Integer id) {
		return autoRenewalRepo.findById(id).get();
	}

	@Override
	public AutoRenewal deleteByAutoRenewalId(Integer id) {
		AutoRenewal delete = findbyAutoRenewalId(id);
		autoRenewalRepo.delete(delete);
		return delete;
	}
	

}
