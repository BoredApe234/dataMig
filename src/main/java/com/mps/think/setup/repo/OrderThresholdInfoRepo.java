package com.mps.think.setup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.OrderThresholdInfo;

@Repository
public interface OrderThresholdInfoRepo extends JpaRepository<OrderThresholdInfo, Integer>{
	
	List<OrderThresholdInfo> findByPublisherId(Integer pubId);
	OrderThresholdInfo findByOrderOrderId(Integer orderId);
}
