package com.mps.think.setup.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.Countries;
import com.mps.think.setup.repo.CountriesRepo;
import com.mps.think.setup.service.CountriesService;
import com.mps.think.setup.vo.CountriesVO;

@Service
public class CountriesServiceImpl implements CountriesService{
	
	@Autowired
	private CountriesRepo countriesRepo;
	
	@Autowired
	private ObjectMapper mapper;

	@Override
	public List<Countries> getAllCountries() {
		return countriesRepo.findAll();
	}

	@Override
	public Countries saveCountries(CountriesVO countries) {
		return countriesRepo.saveAndFlush(mapper.convertValue(countries, Countries.class));
	}

	@Override
	public Countries updateCountries(CountriesVO countries) {
		return countriesRepo.saveAndFlush(mapper.convertValue(countries, Countries.class));
	}

	@Override
	public Countries findbyCountriesId(Integer id) {
		return countriesRepo.findById(id).get();
	}

	@Override
	public Countries deleteByCountriesId(Integer id) {
		Countries delete = findbyCountriesId(id);
		countriesRepo.delete(delete);
		return delete;
	}

	@Override
	public List<Countries> findAllCountriesForPublisher(Integer pubId) {
		return countriesRepo.findByPubIdId(pubId);
	}

	

}
