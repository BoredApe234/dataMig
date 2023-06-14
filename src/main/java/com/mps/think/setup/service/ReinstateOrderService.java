package com.mps.think.setup.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mps.think.setup.exception.OrdersNotReinsatedException;
import com.mps.think.setup.model.Order;
import com.mps.think.setup.model.OrdersToBeSuspended;
import com.mps.think.setup.model.ReinstateOrder;
import com.mps.think.setup.vo.OrderSuspendView;
import com.mps.think.setup.vo.ReinstateOrderVO;

public interface ReinstateOrderService {

	ReinstateOrder saveReinstateOrderDetailsAndReinstateOrders(ReinstateOrderVO reinstateOrder);
	
	Page<OrderSuspendView> getAllOrdersToReinstateByOrderId(Integer orderId, Pageable page);
	
}
