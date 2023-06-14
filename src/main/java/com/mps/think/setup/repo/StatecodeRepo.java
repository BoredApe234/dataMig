package com.mps.think.setup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mps.think.setup.model.Statecode;

@Repository
public interface StatecodeRepo extends JpaRepository<Statecode, Integer>{
	
	List<Statecode> findByCountry(String country);

}
