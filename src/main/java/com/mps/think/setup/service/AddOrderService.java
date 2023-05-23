package com.mps.think.setup.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mps.think.setup.model.Order;
import com.mps.think.setup.model.OrderCodesSuper;
import com.mps.think.setup.vo.OrderVO;

@Service
public interface AddOrderService {
	
	public Order saveOrder(OrderVO order) throws Exception;
	public Page<Order> getAllOrders(Pageable page) throws Exception;
	public Order getOrderById(Integer orderId) throws Exception;
	public Page<Order> getAllOrderByCustomerId(Integer customerId, Pageable page) throws Exception;
	public Order updateOrder(Order order) throws Exception;
	public List<Order> getAllOrdersByOrderClassId(Integer ocId) throws Exception;
	
	public Page<Order> getAllorderForPublisher(Pageable page,Integer pubId) throws Exception;

	public Page<Order> getSearchedOrders(Integer pubId, Integer customerId, String keyword, Pageable page);
	
	List<OrderCodesSuper> getRecentTwoOrderOfCustomer(Integer customerId) throws Exception;
	
	void setAllOrdersOfCustomerInActive(Integer customerId);
	
}
