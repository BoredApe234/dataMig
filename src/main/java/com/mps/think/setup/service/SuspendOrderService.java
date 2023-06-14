package com.mps.think.setup.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.text.ParseException;
import java.util.List;

import com.mps.think.setup.exception.OrdersNotSuspended;
import com.mps.think.setup.model.OrdersToBeSuspended;
import com.mps.think.setup.model.SuspendOrder;
import com.mps.think.setup.vo.OrderSuspendView;
import com.mps.think.setup.vo.SuspendOrderVO;

public interface SuspendOrderService {
	
	SuspendOrder saveSuspendOrdersDetail(SuspendOrderVO suspendOrdersDetail);
	
	Page<OrderSuspendView> findOrdersByIdWithSuspensionDetails(Integer orderId, Pageable page);
	
}
