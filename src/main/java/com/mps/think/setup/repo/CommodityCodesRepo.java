package com.mps.think.setup.repo;

import java.util.List;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mps.think.setup.model.CommodityCodes;

public interface CommodityCodesRepo extends JpaRepository<CommodityCodes , Integer> {
	
	public CommodityCodes findCommodityCodesById(Integer id);
	
	List<CommodityCodes> findByPubIdId(Integer pubId);

}
