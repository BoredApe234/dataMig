package com.mps.think.setup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.LableFormatGroups;

@Repository
public interface LableFormatGroupsRepo extends JpaRepository<LableFormatGroups, Integer> {
	
	public List<LableFormatGroups> findByPubIdId(Integer publisherId);

}
