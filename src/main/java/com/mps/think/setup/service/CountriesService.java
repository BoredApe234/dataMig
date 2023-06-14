package com.mps.think.setup.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.mps.think.setup.model.Countries;
import com.mps.think.setup.vo.CountriesVO;


@Service
public interface CountriesService {
	
	public List<Countries> getAllCountries();
	
	public Countries saveCountries(CountriesVO countries);

	public Countries updateCountries(CountriesVO countries);

	public Countries findbyCountriesId(Integer id);
	
	public Countries deleteByCountriesId(Integer id);
	
	List<Countries> findAllCountriesForPublisher(Integer pubId);

}
