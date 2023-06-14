package com.mps.think.setup.serviceImpl;

import java.time.Clock;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.exception.OrdersNotSuspended;
import com.mps.think.setup.model.Order;
import com.mps.think.setup.model.OrdersToBeSuspended;
import com.mps.think.setup.model.SuspendOrder;
import com.mps.think.setup.repo.AddOrderRepo;
import com.mps.think.setup.repo.OrdersToBeSuspendedRepo;
import com.mps.think.setup.repo.SuspendOrderRepo;
import com.mps.think.setup.service.SuspendOrderService;
import com.mps.think.setup.vo.EnumModelVO.OrderStatus;
import com.mps.think.setup.vo.OrderCompactView;
import com.mps.think.setup.vo.OrderSuspendView;
import com.mps.think.setup.vo.SuspendOrderVO;

@Service
public class SuspendOrderServiceImpl implements SuspendOrderService {

	@Autowired
	private SuspendOrderRepo suspendOrderRepo;

	@Autowired
	private ObjectMapper mapper;

	@Autowired
	private OrdersToBeSuspendedRepo ordersToBeSuspendedRepo;

	@Autowired
	private AddOrderRepo orderRepo;

	/*
	 * For a particular order only one permanent suspension can be there, but if we
	 * are provided with another permanent suspension detail we'll have to remove
	 * the permanent suspension of that order if there exist any and the new
	 * suspension will be applied to that order, so we are using a flag in our code
	 * below to check if the provided suspension details are for permanent
	 * suspension that we must check for the given order that if there any permanent
	 * suspension exist just remove them and imply the new one.
	 * 
	 * also we need to check if the given suspension is permanent and it's starting
	 * dates comes before the starting date of some temp suspensions for that
	 * particular order then we'll remove all those temp suspensions as the given
	 * permanent suspension will override all of them.
	 * 
	 */

	@Override
	public SuspendOrder saveSuspendOrdersDetail(SuspendOrderVO suspendOrdersDetail) {
		SuspendOrder suspendOrders = mapper.convertValue(suspendOrdersDetail, SuspendOrder.class);
		boolean flag = suspendOrders.getSetOrderStatus().equals(OrderStatus.suspend_for_nonpayment);
		suspendOrders.getOrdersToSuspend().forEach(o -> {
			if (flag) {
				boolean check = checkPreviousSuspensionIfNewGivenSusIsNonPay(o);
				if (!check)
					throw new OrdersNotSuspended("orders : " + suspendOrders.getOrdersToSuspend().stream()
							.map(s -> s.getOrder().getOrderId()).collect(Collectors.toList())
							+ " can not be put to suspension");
			}
			o.setIsReinstated(false);
			o.setIsSuspended(false);
			o.setIsValid(true);
		});
		SuspendOrder susDet = suspendOrderRepo.saveAndFlush(suspendOrders);
		susDet.getOrdersToSuspend()
				.forEach(o -> checkOrdersToSuspend(o.getOrder().getOrderId(), o.getSuspendOrder().getId()));
		return susDet;
	}

	boolean checkPreviousSuspensionIfNewGivenSusIsNonPay(OrdersToBeSuspended o) {
		try {
			List<OrdersToBeSuspended> suspensionsForGiveOrder = ordersToBeSuspendedRepo
					.findAllSuspensionForGiveOrderId(o.getOrder().getOrderId());
			suspensionsForGiveOrder.forEach(so -> {
				if (so.getSuspendOrder().getSetOrderStatus().equals(OrderStatus.suspend_for_nonpayment)) {
					OrdersToBeSuspended orderToSuspend = ordersToBeSuspendedRepo
							.getOrdersToBeSuspendedForGivenOrderAndSuspendDetails(so.getOrder().getOrderId(),
									so.getSuspendOrder().getId());
					orderToSuspend.setIsValid(false);
					ordersToBeSuspendedRepo.saveAndFlush(orderToSuspend);
				} else if (so.getSuspendOrder().getSetOrderStatus().equals(OrderStatus.temporary_suspend)) {
					LocalDate earlierTempSuspensionStart = so.getSuspendOrder().getSuspendedfrom().toInstant()
							.atZone(ZoneId.systemDefault()).toLocalDate();
					LocalDate newPermanentSuspensionStart = o.getSuspendOrder().getSuspendedfrom().toInstant()
							.atZone(ZoneId.systemDefault()).toLocalDate();
					if (newPermanentSuspensionStart.isBefore(earlierTempSuspensionStart)
							|| newPermanentSuspensionStart.isEqual(earlierTempSuspensionStart)) {
						OrdersToBeSuspended orderToSuspend = ordersToBeSuspendedRepo
								.getOrdersToBeSuspendedForGivenOrderAndSuspendDetails(so.getOrder().getOrderId(),
										so.getSuspendOrder().getId());
						orderToSuspend.setIsValid(false);
						ordersToBeSuspendedRepo.saveAndFlush(orderToSuspend);
					}
				}
			});
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// will have to put this in scheduler
	public void checkOrdersToSuspend(Integer orderId, Integer suspensionId) {
		LocalDate currentDate = LocalDate.now(Clock.systemDefaultZone());
		List<Object[]> nonSuspendedOrders = ordersToBeSuspendedRepo.findAllNonSuspendedAndNonReinstatedOrders(orderId,
				suspensionId);
		for (Object[] o : nonSuspendedOrders) {
			Order order = (Order) o[0];
			SuspendOrder suspendDetails = (SuspendOrder) o[1];
			LocalDate suspensionStartFrom = suspendDetails.getSuspendedfrom().toInstant().atZone(ZoneId.systemDefault())
					.toLocalDate();
			if (currentDate.isBefore(suspensionStartFrom))
				continue;
			suspendOrContinueOrder(order, suspendDetails.getSetOrderStatus());
			OrdersToBeSuspended ordersToBeSuspendedForGivenOrderAndSuspendDetails = ordersToBeSuspendedRepo
					.getOrdersToBeSuspendedForGivenOrderAndSuspendDetails(order.getOrderId(), suspendDetails.getId());
			ordersToBeSuspendedForGivenOrderAndSuspendDetails.setIsSuspended(true);
			ordersToBeSuspendedRepo.saveAndFlush(ordersToBeSuspendedForGivenOrderAndSuspendDetails);
			if (suspendDetails.getSetOrderStatus().equals(OrderStatus.suspend_for_nonpayment)) {
				makeAllExistingTempSupensionsInvalid(order.getOrderId(), suspendDetails.getId());
			}
		}
	}

	private void makeAllExistingTempSupensionsInvalid(Integer orderId, Integer suspensionId) {
		List<OrdersToBeSuspended> allSuspensionsForOrder = ordersToBeSuspendedRepo
				.findAllSuspensionForGiveOrderId(orderId);
		for (OrdersToBeSuspended s : allSuspensionsForOrder) {
			if (s.getSuspendOrder().getId().equals(suspensionId))
				continue;
			OrdersToBeSuspended susDet = ordersToBeSuspendedRepo
					.getOrdersToBeSuspendedForGivenOrderAndSuspendDetails(orderId, s.getSuspendOrder().getId());
			susDet.setIsValid(false);
			ordersToBeSuspendedRepo.saveAndFlush(susDet);
		}
	}

	private void suspendOrContinueOrder(Order order, String setOrderStatus) {
		order.setOrderStatus(setOrderStatus);
		orderRepo.saveAndFlush(order);
	}

	// goes into scheduler
	public void checkOrdersToContinue() {
		LocalDate currentDate = LocalDate.now(Clock.systemDefaultZone());
		List<Object[]> allSuspendedOrders = ordersToBeSuspendedRepo.findAllSuspendedAndNonReinstatedOrders();
		for (Object[] o : allSuspendedOrders) {
			Order order = (Order) o[0];
			SuspendOrder suspendDetails = (SuspendOrder) o[1];
			LocalDate suspendedTill = suspendDetails.getSuspendedTo().toInstant().atZone(ZoneId.systemDefault())
					.toLocalDate();
			if (currentDate.isBefore(suspendedTill) || order.getOrderStatus().equals(OrderStatus.suspend_for_nonpayment))
				continue;
			suspendOrContinueOrder(order, suspendDetails.getCurrentOrderStatus());
			OrdersToBeSuspended ordersToBeSuspendedForGivenOrderAndSuspendDetails = ordersToBeSuspendedRepo
					.getOrdersToBeSuspendedForGivenOrderAndSuspendDetails(order.getOrderId(), suspendDetails.getId());
			ordersToBeSuspendedForGivenOrderAndSuspendDetails.setIsReinstated(true);
			ordersToBeSuspendedRepo.saveAndFlush(ordersToBeSuspendedForGivenOrderAndSuspendDetails);
		}
	}

	@Override
	public Page<OrderSuspendView> findOrdersByIdWithSuspensionDetails(Integer orderId, Pageable page) {
		Integer parentOrderId = orderRepo.findById(orderId).get().getParentOrder().getParentOrderId();
		Page<Object[]> orderIdAndSuspendDetId = suspendOrderRepo.findAllOrdersByIdWithSuspensionDet(parentOrderId,
				page);
		List<OrderSuspendView> output = new ArrayList<>();
		for (Object[] o : orderIdAndSuspendDetId) {
			Order order = orderRepo.findById((int) o[0]).get();
			OrderCompactView ocv = new OrderCompactView();
			ocv.setOrderId(order.getOrderId());
			ocv.setParentOrderId(order.getParentOrder().getParentOrderId());
			ocv.setCurrentOrderStatus(order.getOrderStatus());
			ocv.setOrderCode(order.getKeyOrderInformation().getOrderCode().getOrderCodes().getOrderCode());
			ocv.setPayment(order.getPaymentBreakdown());
			ocv.setStartDate(order.getOrderItemsAndTerms().getValidFrom());
			ocv.setEndDate(order.getOrderItemsAndTerms().getValidTo());
			ocv.setCustomerId(order.getCustomerId().getCustomerId());
			ocv.setCustomerFirstName(order.getCustomerId().getFname());
			ocv.setCustomerLastName(order.getCustomerId().getLname());
			SuspendOrder suspendOrder = o[1] == null ? null : suspendOrderRepo.findById((int) o[1]).get();
			if (suspendOrder != null)
				suspendOrder.setOrdersToSuspend(null);
			output.add(new OrderSuspendView(ocv, suspendOrder));
		}
		return new PageImpl<>(output, orderIdAndSuspendDetId.getPageable(), orderIdAndSuspendDetId.getTotalElements());
	}
	
	
	public List<SuspendOrder> getAllSuspensions() {
		return suspendOrderRepo.findAll();
	}

}
