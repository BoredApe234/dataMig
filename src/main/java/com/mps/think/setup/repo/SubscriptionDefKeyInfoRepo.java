package com.mps.think.setup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.SubscriptionDefKeyInfo;

@Repository
public interface SubscriptionDefKeyInfoRepo extends JpaRepository<SubscriptionDefKeyInfo, Integer> {

	List<SubscriptionDefKeyInfo> findByPublisherId(Integer id);

	List<SubscriptionDefKeyInfo> findByOrderClassOcId(Integer id);
	
	List<SubscriptionDefKeyInfo> findByOrderCodeId(Integer orderCodeId);
	
}
