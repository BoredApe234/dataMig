package com.mps.think.setup.serviceImpl;


import java.util.Arrays;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.Order;
import com.mps.think.setup.model.OrderCodesSuper;
import com.mps.think.setup.repo.AddOrderRepo;
import com.mps.think.setup.service.AddOrderService;
import com.mps.think.setup.vo.EnumModelVO.OrderStatus;
import com.mps.think.setup.vo.OrderVO;

@Service
public class AddOrderServiceImpl implements AddOrderService {

	@Autowired
	private AddOrderRepo addOrderRepo;
	
	@Autowired
	private ObjectMapper mapper;

	@Override
	public Order saveOrder(OrderVO order) throws Exception {
//		ObjectMapper mapper = new ObjectMapper();
		Order newOrder = mapper.convertValue(order, Order.class);
		if (order.getOtherAddressCustomer().getCustomerId() == 0) newOrder.setOtherAddressCustomer(null);
		return addOrderRepo.saveAndFlush(newOrder);
	}

	@Override
	public Page<Order> getAllOrders(Pageable page) throws Exception {
		return addOrderRepo.findAll(page);
	}

	@Override
	public Order getOrderById(Integer orderId) throws Exception {
		return addOrderRepo.findById(orderId).get();
	}

	@Override
	public Page<Order> getAllOrderByCustomerId(Integer customerId, Pageable page) throws Exception {
//		return addOrderRepo.findAllByCustomerId(customerId);
		return addOrderRepo.findByCustomerIdCustomerId(customerId, page);
	}

	@Override
	public Order updateOrder(Order order) throws Exception {
//		ObjectMapper mapper = new ObjectMapper();
		Order updateOrder = mapper.convertValue(order, Order.class);
		if (order.getOtherAddressCustomer().getCustomerId() == 0) updateOrder.setOtherAddressCustomer(null);
		return addOrderRepo.saveAndFlush(updateOrder);
	}

	@Override
	public List<Order> getAllOrdersByOrderClassId(Integer ocId) throws Exception {
		return addOrderRepo.findByOrderClassOcId(ocId);
	}

	@Override
	public Page<Order> getSearchedOrders(Integer pubId, Integer customerId, String keyword, Pageable page) {
		return addOrderRepo.findOrdersBySearch(pubId.equals(0) ? null : pubId, customerId, keyword, page);
	}

	@Override
	public List<OrderCodesSuper> getRecentTwoOrderOfCustomer(Integer customerId) throws Exception {
		List<Order> orders = addOrderRepo.findByCustomerIdCustomerId(customerId);
		if (orders.size() <= 2) return orders.stream().map(o -> o.getKeyOrderInformation().getOrderCode()).collect(Collectors.toList());
		Order order1 = orders.stream().max(Comparator.comparingInt(Order::getOrderId)).get();
		orders.remove(order1);
		Order order2 = orders.stream().max(Comparator.comparingInt(Order::getOrderId)).get();
		return Arrays.asList(order1.getKeyOrderInformation().getOrderCode(), order2.getKeyOrderInformation().getOrderCode());
	}

	@Override
	public Page<Order> getAllorderForPublisher(Pageable page,Integer pubId) throws Exception {
		return addOrderRepo.findAllByCustomerIdPublisherId(page,pubId);
	}

	@Override
	public void setAllOrdersOfCustomerInActive(Integer customerId) {
		List<Order> orders = addOrderRepo.findByCustomerIdCustomerId(customerId);
		orders.forEach(o -> {
			o.setOrderStatus(OrderStatus.Cancelled);
		});
		addOrderRepo.saveAllAndFlush(orders);
	}

	

	

}
