package com.mps.think.setup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mps.think.setup.model.SubscriptionCategory;

public interface SubscriptionCategoryRepo extends JpaRepository<SubscriptionCategory , Integer> {
	
	public SubscriptionCategory findSubscriptionCategoryById(Integer id);
	public List<SubscriptionCategory> findByPubIdId(Integer id);

}
