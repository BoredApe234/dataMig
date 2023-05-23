package com.mps.think.setup.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.mps.think.setup.model.OrderCodes;
import com.mps.think.setup.model.OrderCodesSuper;
import com.mps.think.setup.model.OrderItemDetails;
import com.mps.think.setup.model.OrderOptions;
import com.mps.think.setup.model.OrderPackageOptions;
import com.mps.think.setup.model.OrderPaymentOptions;
import com.mps.think.setup.model.Terms;
import com.mps.think.setup.vo.OrderCodesSuperVO;

@Service
public interface OrderCodesService {
	
	public OrderCodesSuper saveOrderCodes(OrderCodesSuperVO orderCodes);
	public OrderCodesSuper updateOrderCodes(OrderCodesSuperVO orderCodes);
	public List<OrderCodesSuper> getOrderByPublisherId(Integer publisherId);

	public OrderCodesSuper getOrderCodesById(Integer orderCodeID);
	public OrderItemDetails getOrderItemDetailsById(Integer itemDetailsId);
	public OrderOptions getOrderOptionsById(Integer orderOptionsId);
	public OrderPackageOptions getOrderPackageOptionsById(Integer orderPkgId);
	public OrderPaymentOptions getOrderPaymentOptionsById(Integer orderPaymentId);
	
	
	// to fetch the record of all order codes...
	public List<OrderCodes> getAllOrderCodes();
	
	// to delete the order
	public OrderCodesSuper deleteOrderCode(Integer id);
	
	public List<OrderCodesSuper> getAllCompleteOrderCodes();
	
	public List<OrderCodesSuper> getAllOrderCodesByOrderClassId(Integer ocId);
	
	public Set<Terms> getAllTermsForOrderCodeByIdOrderCodeId(Integer orderCodeId); 
	
}
