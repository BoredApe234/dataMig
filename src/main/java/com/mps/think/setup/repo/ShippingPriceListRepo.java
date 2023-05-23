package com.mps.think.setup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.ShippingPriceList;

@Repository
public interface ShippingPriceListRepo extends JpaRepository<ShippingPriceList, Integer> {

	public ShippingPriceList findShippingPriceListById(Integer id);
	
	List<ShippingPriceList> findByPublisherId(Integer pubId);

}
