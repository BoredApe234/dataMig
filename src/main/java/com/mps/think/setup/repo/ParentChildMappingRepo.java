package com.mps.think.setup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.ParentChildMapping;
@Repository
public interface ParentChildMappingRepo extends JpaRepository<ParentChildMapping, Integer>{

	List<ParentChildMapping> findByParentIdPubIdId(Integer pubId);
}
