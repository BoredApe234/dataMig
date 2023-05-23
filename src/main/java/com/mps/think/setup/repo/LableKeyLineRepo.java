package com.mps.think.setup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.mps.think.setup.model.LableKeyLine;
@Repository
public interface LableKeyLineRepo extends JpaRepository<LableKeyLine, Integer> {
	
	public List<LableKeyLine> findByPubIdId(Integer publisherId);

}
