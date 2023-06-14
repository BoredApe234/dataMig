package com.mps.think.setup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mps.think.setup.model.LabelLayout;

@Repository
public interface LabelLayoutRepo extends JpaRepository<LabelLayout, Integer> {
	
	List<LabelLayout> findByPubIdId(Integer pubId);

}
