package com.mps.think.setup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.TaxRateCategory;

@Repository
public interface TaxRateCategoryRepo extends JpaRepository<TaxRateCategory, Integer>{
	
//	public TaxRateCategory findByTaxCId(Integer id);
	
	List<TaxRateCategory> findByPubIdId(Integer pubId);

}
