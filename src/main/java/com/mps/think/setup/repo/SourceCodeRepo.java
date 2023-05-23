package com.mps.think.setup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.mps.think.setup.model.SourceCode;

@Repository
public interface SourceCodeRepo extends JpaRepository<SourceCode ,  Integer> {
	
	List<SourceCode> findByOcIdPubIdId(Integer pubId);
	
}
