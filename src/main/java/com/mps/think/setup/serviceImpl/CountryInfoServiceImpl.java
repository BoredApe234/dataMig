package com.mps.think.setup.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mps.think.setup.model.CountryInfo;
import com.mps.think.setup.repo.CountryInfoRepo;
import com.mps.think.setup.service.CountryInfoService;

@Service
public class CountryInfoServiceImpl implements CountryInfoService {
	
	@Autowired
	CountryInfoRepo countryInfoRepo;

	@Override
	public List<CountryInfo> getAllName() {
		return countryInfoRepo.findAll();
	}




}
