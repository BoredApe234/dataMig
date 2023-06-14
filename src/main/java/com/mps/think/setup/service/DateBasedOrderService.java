package com.mps.think.setup.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mps.think.setup.model.Order;
import com.mps.think.setup.vo.DateBasedOrderVO;

public interface DateBasedOrderService {

	DateBasedOrderVO saveDateBasedOrder(DateBasedOrderVO order) throws Exception;
	
	DateBasedOrderVO updateDateBasedOrder(DateBasedOrderVO order) throws Exception;
	
	Page<Order> findAllDateBasedOrders(Integer publisherId, Integer customerId, Pageable page);
	
}
