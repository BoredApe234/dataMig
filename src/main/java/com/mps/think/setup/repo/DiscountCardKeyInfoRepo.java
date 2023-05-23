package com.mps.think.setup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.DiscountCardKeyInfo;


@Repository
public interface DiscountCardKeyInfoRepo extends JpaRepository<DiscountCardKeyInfo, Integer> {

	List<DiscountCardKeyInfo> findByOrderClassOcId(Integer id);
	
	List<DiscountCardKeyInfo> findByOrderClassPubIdId(Integer pubId);
	
}
