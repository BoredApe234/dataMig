package com.mps.think.setup.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.Jurisdictions;

@Repository
public interface JurisdictionsRepo extends JpaRepository<Jurisdictions , Integer> {
	
	public Jurisdictions findJurisdictionsById(Integer id);

	List<Jurisdictions> findByPubIdId(Integer pubId);

}
