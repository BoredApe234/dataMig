package com.mps.think.setup.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.Taxonomy;
import com.mps.think.setup.model.ValueForScAttribute;



@Repository
public interface ValueForScAttributeRepo extends JpaRepository<ValueForScAttribute,Integer>{
	
	public Taxonomy findValueForScAttributeById(Integer id);

}
