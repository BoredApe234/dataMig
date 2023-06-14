package com.mps.think.setup.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mps.think.setup.model.CountryInfo;

@Service
public interface CountryInfoService {
	
	public List<CountryInfo> getAllName();

}
