package com.mps.think.setup.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.Order;
import com.mps.think.setup.model.OrderClass;
import com.mps.think.setup.model.OrderThresholdInfo;
import com.mps.think.setup.model.Publisher;
import com.mps.think.setup.model.SourceCode;
import com.mps.think.setup.model.Terms;
import com.mps.think.setup.repo.OrderThresholdInfoRepo;
import com.mps.think.setup.service.OrderThresholdInfoService;
import com.mps.think.setup.vo.OrderThresholdInfoVO;
@Service
public class OrderThresholdInfoServiceImpl implements OrderThresholdInfoService{
	@Autowired
	OrderThresholdInfoRepo thresholdInfoRepo;
	
	@Autowired
	ObjectMapper mapper;

	@Override
	public List<OrderThresholdInfo> findAllorderThresholdByPubId(Integer pubId) {
		return thresholdInfoRepo.findByPublisherId(pubId);
	}

	@Override
	public List<OrderThresholdInfo> saveorderThresholdInfo(List<OrderThresholdInfoVO> orderThresholdInfoVO) {
//		OrderThresholdInfo ot=new OrderThresholdInfo();
//		OrderClass oc=new OrderClass();
//		oc.setOcId(orderThresholdInfoVO.getOrderClass().getOcId());
//		ot.setOrderClass(oc);
//		Terms term=new Terms();
//		term.setTermsId(orderThresholdInfoVO.getTerms().getTermsId());
//		ot.setTerms(term);
//		SourceCode sc=new SourceCode();
//		sc.setSourceCodeId(orderThresholdInfoVO.getSourceCode().getSourceCodeId());
//		ot.setSourceCode(sc);
//		Order order=new Order();
//		order.setOrderId(orderThresholdInfoVO.getOrder().getOrderId());
//		ot.setOrder(order);
//		ot.setCustomerNbr(orderThresholdInfoVO.getCustomerNbr());
//		ot.setOrderNbr(orderThresholdInfoVO.getOrderNbr());
//		ot.setStartDate(orderThresholdInfoVO.getStartDate());
//		ot.setLineItem(orderThresholdInfoVO.getLineItem());
//		ot.setOrderDate(orderThresholdInfoVO.getOrderDate());
//		ot.setTotalPaid(orderThresholdInfoVO.getTotalPaid());
//		ot.setUnderPaymentOption(orderThresholdInfoVO.getUnderPaymentOption());
//		if(orderThresholdInfoVO.getPaymentStatus().equalsIgnoreCase("Prorate Issues")) {
//			ot.setExpirationOriginal(orderThresholdInfoVO.getExpirationOriginal());
//			ot.setExpirationProrated(orderThresholdInfoVO.getExpirationProrated());
//			ot.setOrderQuantityOriginal(orderThresholdInfoVO.getOrderQuantityOriginal());
//			ot.setOrderQuantityProrated(orderThresholdInfoVO.getOrderQuantityProrated());
//			ot.setRemainingOriginal(orderThresholdInfoVO.getRemainingOriginal());
//			ot.setRemainingProrated(orderThresholdInfoVO.getRemainingProrated());
//			ot.setOrderAmntSubsOriginal(orderThresholdInfoVO.getOrderAmntSubsOriginal());
//			ot.setOrderAmntSubsProrated(orderThresholdInfoVO.getOrderAmntSubsProrated());
//			ot.setOrderAmntDeliveryOriginal(orderThresholdInfoVO.getOrderAmntDeliveryOriginal());
//			ot.setOrderAmntDeliveryProrated(orderThresholdInfoVO.getOrderAmntDeliveryProrated());
//			ot.setOrderAmntTaxOriginal(orderThresholdInfoVO.getOrderAmntTaxOriginal());
//			ot.setOrderAmntTaxProrated(orderThresholdInfoVO.getOrderAmntTaxProrated());
//		}
//		Publisher pub=new Publisher();
//		pub.setId(orderThresholdInfoVO.getPublisher().getId());
//		ot.setPublisher(pub);
//		OrderThresholdInfo data = thresholdInfoRepo.saveAndFlush(ot);
//		ot.setId(data.getId());
		List<OrderThresholdInfo> list=new ArrayList<>();
		for(OrderThresholdInfoVO orderList:orderThresholdInfoVO) {
		OrderThresholdInfo data = thresholdInfoRepo.saveAndFlush(mapper.convertValue(orderList, OrderThresholdInfo.class));
		list.add(data);
		}
		return list;
	}

	@Override
	public OrderThresholdInfo findbyOrderId(Integer orderId) {
		return thresholdInfoRepo.findByOrderOrderId(orderId);
	}

	@Override
	public List<OrderThresholdInfo> getAllOrderThresholdInfo() {
		return thresholdInfoRepo.findAll();
	}

}
