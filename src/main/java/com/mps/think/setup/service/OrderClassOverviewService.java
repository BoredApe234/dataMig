package com.mps.think.setup.service;

import java.util.List;

import com.mps.think.setup.model.OrderClassOverview;
import com.mps.think.setup.vo.OrderClassOverviewVO;

public interface OrderClassOverviewService {

	public OrderClassOverview saveOrderClassOverview(OrderClassOverviewVO overview);
	
	public OrderClassOverview updateOrderClassOverview(OrderClassOverviewVO overview);
	
	public OrderClassOverview deleteOrderClassOverviewById(Integer id);
	
	public OrderClassOverview findOrderClassOverviewById(Integer id);
	
	public List<OrderClassOverview> getAllOrderClassOverviewByPubId(Integer pubId);
	
	public List<OrderClassOverview> getAllOrderClassOverview();
	
	public List<OrderClassOverview> getAllOrderClassOverviewByOrderClassId(Integer ocId);
	
}
