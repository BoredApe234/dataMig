package com.mps.think.setup.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mps.think.setup.model.CancelOrder;
import com.mps.think.setup.vo.CancelOrderVO;

@Service
public interface CancelOrderService {
	
	public List<CancelOrder> getAllCancelOrder();
	
	public CancelOrderVO saveCancelOrder(CancelOrderVO cancelOrder);
	
	public CancelOrderVO updateCancelOrder(CancelOrderVO cancelOrder);
	
	public CancelOrder findbyCancelOrderId(Integer cancelOrder);

	public List<CancelOrder> getAllCancelOrderByCancelorderId(Integer cancelOrder);

}
