package com.mps.think.setup.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mps.think.setup.model.Countries;

@Repository
public interface CountriesRepo extends JpaRepository<Countries, Integer>{
	
	List<Countries> findByPubIdId(Integer pubId);

}
