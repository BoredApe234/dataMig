package com.mps.think.setup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.ShippingMethod;

@Repository
public interface ShippingMethodRepo extends JpaRepository<ShippingMethod, Integer> {

	public ShippingMethod findShippingMethodById(Integer id);
	
	List<ShippingMethod> findByPublisherId(Integer pubId);
	
}
