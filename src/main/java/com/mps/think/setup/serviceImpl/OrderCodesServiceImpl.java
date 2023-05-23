package com.mps.think.setup.serviceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.OrderCodes;
import com.mps.think.setup.model.OrderCodesSuper;
import com.mps.think.setup.model.OrderItemDetails;
import com.mps.think.setup.model.OrderOptions;
import com.mps.think.setup.model.OrderPackageOptions;
import com.mps.think.setup.model.OrderPaymentOptions;
import com.mps.think.setup.model.SubscriptionDefKeyInfo;
import com.mps.think.setup.model.Terms;
import com.mps.think.setup.repo.OrderCodesSuperRepo;
import com.mps.think.setup.repo.SubscriptionDefKeyInfoRepo;
import com.mps.think.setup.service.OrderCodesService;
import com.mps.think.setup.vo.OrderCodesSuperVO;

@Service
public class OrderCodesServiceImpl implements OrderCodesService {

	@Autowired
	private OrderCodesSuperRepo orderCodesSuperRepo;
	
	@Autowired
	private SubscriptionDefKeyInfoRepo subsDefRepo;

	@Override
	public OrderCodesSuper saveOrderCodes(OrderCodesSuperVO orderCodes) {
		ObjectMapper mapper = new ObjectMapper();
		OrderCodesSuper newOrderCode = mapper.convertValue(orderCodes, OrderCodesSuper.class);
		orderCodesSuperRepo.saveAndFlush(newOrderCode);
		return newOrderCode;
	}

	@Override
	public OrderCodesSuper updateOrderCodes(OrderCodesSuperVO orderCodes) {
		ObjectMapper mapper = new ObjectMapper();
		OrderCodesSuper orderCodeToUpdate = mapper.convertValue(orderCodes, OrderCodesSuper.class);
		orderCodesSuperRepo.saveAndFlush(orderCodeToUpdate);
		return orderCodeToUpdate;
	}

	@Override
	public List<OrderCodesSuper> getOrderByPublisherId(Integer publisherId) {
		return orderCodesSuperRepo.findByPublisherId(publisherId);
	}

	@Override
	public OrderCodesSuper getOrderCodesById(Integer orderCodeID) {
		Optional<OrderCodesSuper> orderCode = orderCodesSuperRepo.findById(orderCodeID);
		return orderCode.isPresent() ? orderCode.get() : null;
	}

	@Override
	public OrderItemDetails getOrderItemDetailsById(Integer itemDetailsId) {
		Optional<OrderCodesSuper> orderCodeItemDetail = orderCodesSuperRepo.findAll().stream().filter(orderCode -> orderCode.getOrderItemDetails().getId().equals(itemDetailsId)).findAny();
		return orderCodeItemDetail.isPresent() ? orderCodeItemDetail.get().getOrderItemDetails() : null;
	}

	@Override
	public OrderOptions getOrderOptionsById(Integer orderOptionsId) {
		Optional<OrderCodesSuper> orderCodeOptions = orderCodesSuperRepo.findAll().stream().filter(orderCode -> orderCode.getOrderOptions().getId().equals(orderOptionsId)).findAny();
		return orderCodeOptions.isPresent() ? orderCodeOptions.get().getOrderOptions() : null;
	}

	@Override
	public OrderPackageOptions getOrderPackageOptionsById(Integer orderPkgId) {
		Optional<OrderCodesSuper> pkgOptions = orderCodesSuperRepo.findAll().stream().filter(orderCode -> orderCode.getOrderPackageOptions().getId().equals(orderPkgId)).findAny();
		return pkgOptions.isPresent() ? pkgOptions.get().getOrderPackageOptions() : null;
	}

	@Override
	public OrderPaymentOptions getOrderPaymentOptionsById(Integer orderPaymentId) {
		Optional<OrderCodesSuper> paymentOptions = orderCodesSuperRepo.findAll().stream().filter(orderCode -> orderCode.getOrderPaymentOptions().getId().equals(orderPaymentId)).findAny();
		return paymentOptions.isPresent() ? paymentOptions.get().getOrderPaymentOptions() : null;
	}

	@Override
	public List<OrderCodes> getAllOrderCodes() {
		List<OrderCodes> allOrderCodes = orderCodesSuperRepo.findAll().stream().map(orderCode -> orderCode.getOrderCodes()).collect(Collectors.toList());
		return allOrderCodes;
	}

	@Override
	public OrderCodesSuper deleteOrderCode(Integer id) {
		OrderCodesSuper orderCode = getOrderCodesById(id);
		if (orderCode == null) return null;
		orderCodesSuperRepo.delete(orderCode);
		return orderCode;
	}
	@Override
	public List<OrderCodesSuper> getAllCompleteOrderCodes() {
		return orderCodesSuperRepo.findAll();
	}

	@Override
	public List<OrderCodesSuper> getAllOrderCodesByOrderClassId(Integer ocId) {
		return orderCodesSuperRepo.findByOrderClassOcId(ocId);
	}

	@Override
	public Set<Terms> getAllTermsForOrderCodeByIdOrderCodeId(Integer orderCodeId) {
		Set<Terms> termsOutput = new HashSet<>();
		subsDefRepo.findByOrderCodeId(orderCodeId).forEach(s -> {
			termsOutput.addAll(s.getTerms());
		});
		return termsOutput;
	}

}
