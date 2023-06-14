package com.mps.think.setup.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.exception.OrdersNotReinsatedException;
import com.mps.think.setup.model.Order;
import com.mps.think.setup.model.OrdersReinstated;
import com.mps.think.setup.model.OrdersToBeSuspended;
import com.mps.think.setup.model.ReinstateOrder;
import com.mps.think.setup.model.SuspendOrder;
import com.mps.think.setup.repo.AddOrderRepo;
import com.mps.think.setup.repo.OrdersToBeSuspendedRepo;
import com.mps.think.setup.repo.ReinstateOrderRepo;
import com.mps.think.setup.repo.SuspendOrderRepo;
import com.mps.think.setup.service.ReinstateOrderService;
import com.mps.think.setup.vo.EnumModelVO.OrderStatus;
import com.mps.think.setup.vo.OrderCompactView;
import com.mps.think.setup.vo.OrderSuspendView;
import com.mps.think.setup.vo.ReinstateOrderVO;

@Service
public class ReinstateOrderServiceImpl implements ReinstateOrderService {

	@Autowired
	ObjectMapper mapper;
	
	@Autowired
	OrdersToBeSuspendedRepo suspendedOrdersRepo;
	
	@Autowired
	ReinstateOrderRepo reinstateOrderRepo;
	
	@Autowired
	AddOrderRepo orderRepo;
	
	@Autowired
	SuspendOrderRepo suspendDetRepo;

	@Override
	public ReinstateOrder saveReinstateOrderDetailsAndReinstateOrders(ReinstateOrderVO reinstateOrder) {
		ReinstateOrder ordersToReinstate = mapper.convertValue(reinstateOrder, ReinstateOrder.class);
		boolean gotReinstated = reinstate(ordersToReinstate);
		if (!gotReinstated) {
			throw new OrdersNotReinsatedException("orders with ids: " + ordersToReinstate.getOrdersToReinstate().stream()
					.map(o -> o.getOrder().getOrderId()).collect(Collectors.toList()) + " didn't get reinstated...");
		}
		return reinstateOrderRepo.saveAndFlush(ordersToReinstate);
	} 

	private boolean reinstate(ReinstateOrder ordersToReinstate) {
		try {
			List<OrdersReinstated> reinstateOrders = ordersToReinstate.getOrdersToReinstate();
			for (OrdersReinstated o : reinstateOrders) {
				Order order = orderRepo.findById(o.getOrder().getOrderId()).get();
				SuspendOrder suspendOrder = suspendDetRepo.findById(o.getSuspendOrder().getId()).get();
				OrdersToBeSuspended ordersToBeSuspendedForGivenOrderAndSuspendDetails = suspendedOrdersRepo.getOrdersToBeSuspendedForGivenOrderAndSuspendDetails(order.getOrderId(), suspendOrder.getId());
				if (ordersToBeSuspendedForGivenOrderAndSuspendDetails != null) {
					ordersToBeSuspendedForGivenOrderAndSuspendDetails.setIsReinstated(true);
					suspendedOrdersRepo.saveAndFlush(ordersToBeSuspendedForGivenOrderAndSuspendDetails);
				}
				List<OrdersToBeSuspended> previousSuspensionDetailsOfOrder = suspendedOrdersRepo.findAllSuspensionForGiveOrderId(order.getOrderId());
				if (previousSuspensionDetailsOfOrder.size() <= 1) {
					order.setOrderStatus(suspendOrder.getCurrentOrderStatus());
					orderRepo.saveAndFlush(order);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Page<OrderSuspendView> getAllOrdersToReinstateByOrderId(Integer orderId, Pageable page) {
		Integer parentOrderId = orderRepo.findById(orderId).get().getParentOrder().getParentOrderId();
		Page<Object[]> ordersToReinstateForOrderId = suspendedOrdersRepo.findOrdersToReinstateForOrderId(parentOrderId, page);
		List<OrderSuspendView> output = new ArrayList<>();
		for (Object[] o : ordersToReinstateForOrderId) {
			Order order = orderRepo.findById((int)o[0]).get();
			OrderCompactView ocv = new OrderCompactView();
			ocv.setOrderId(order.getOrderId());
			ocv.setParentOrderId(order.getParentOrder() != null ? order.getParentOrder().getParentOrderId() : null);
			ocv.setCurrentOrderStatus(order.getOrderStatus());
			ocv.setOrderCode(order.getKeyOrderInformation().getOrderCode().getOrderCodes().getOrderCode());
			ocv.setPayment(order.getPaymentBreakdown());
			ocv.setStartDate(order.getOrderItemsAndTerms().getValidFrom());
			ocv.setEndDate(order.getOrderItemsAndTerms().getValidTo());
			ocv.setCustomerId(order.getCustomerId().getCustomerId());
			ocv.setCustomerFirstName(order.getCustomerId().getFname());
			ocv.setCustomerLastName(order.getCustomerId().getLname());
			SuspendOrder so = suspendDetRepo.findById((int)o[1]).get();
			so.setOrdersToSuspend(null);
			output.add(new OrderSuspendView(ocv, so));
		}
		return new PageImpl<>(output, ordersToReinstateForOrderId.getPageable(), ordersToReinstateForOrderId.getTotalElements());
	}
	
	public List<ReinstateOrder> findAllReintate() {
		return reinstateOrderRepo.findAll();
	}

}
