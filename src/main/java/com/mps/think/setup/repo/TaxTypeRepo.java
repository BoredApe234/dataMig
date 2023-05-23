package com.mps.think.setup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.TaxType;
@Repository
public interface TaxTypeRepo extends JpaRepository<TaxType, Integer> {
	
	public TaxType findByTaxId(Integer id);

	List<TaxType> findByPubIdId(Integer pubId);
	
}
