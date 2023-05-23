package com.mps.think.setup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.RateCardsRenewals;
import com.mps.think.setup.model.SourceAttributeValues;
import com.mps.think.setup.model.SourceAttributes;
@Repository
public interface SourceAttributeValuesRepo extends JpaRepository<SourceAttributeValues, Integer> {
	
	List<SourceAttributeValues> findBySourceAttributesIdId(Integer id);
	
	List<SourceAttributeValues> findByPublisherId(Integer pubId);


}
