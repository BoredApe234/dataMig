package com.mps.think.setup.service;

import java.util.List;

import com.mps.think.setup.model.Jurisdictions;
import com.mps.think.setup.vo.JurisdictionsVO;

public interface JurisdictionsService {
	
	public List<Jurisdictions> findAllJurisdictions();

	public JurisdictionsVO saveJurisdictions(JurisdictionsVO jurisdictions);

	public JurisdictionsVO updateJurisdictions(JurisdictionsVO jurisdictions);

	public Jurisdictions findbyId(Integer id);
	
	public Jurisdictions deleteJurisdictionsById(Integer id);
	
	List<Jurisdictions> findAllJurisdictionsForPublisher(Integer pubId);

}
