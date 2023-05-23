package com.mps.think.setup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mps.think.setup.model.UnitBasedSubscription;

@Repository
public interface UnitBasedSubscriptionRepo extends JpaRepository<UnitBasedSubscription,Integer>{
	
	public List<UnitBasedSubscription> findByPubIdId(Integer publisherId);

}
