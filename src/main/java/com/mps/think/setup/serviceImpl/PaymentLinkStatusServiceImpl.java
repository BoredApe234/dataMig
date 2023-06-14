package com.mps.think.setup.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.PaymentLinkStatus;
import com.mps.think.setup.repo.PaymentLinkStatusRepo;
import com.mps.think.setup.service.PaymentLinkStatusService;
import com.mps.think.setup.vo.PaymentLinkStatusVO;
@Service
public class PaymentLinkStatusServiceImpl implements PaymentLinkStatusService{
	@Autowired
	PaymentLinkStatusRepo paymentLinkStatusRepo;
	
	@Autowired
	ObjectMapper mapper;

	@Override
	public List<PaymentLinkStatus> getAllPaymentLinkStatus(Integer pubId) {
		return paymentLinkStatusRepo.findByPublisherId(pubId);
	}

	@Override
	public PaymentLinkStatus savePaymentLinkStatus(PaymentLinkStatusVO paymentLinkStatusVO) {
		return paymentLinkStatusRepo.saveAndFlush(mapper.convertValue(paymentLinkStatusVO, PaymentLinkStatus.class));
	}

	@Override
	public PaymentLinkStatus updatePaymentLinkStatus(PaymentLinkStatusVO paymentLinkStatusVO) {
		return paymentLinkStatusRepo.saveAndFlush(mapper.convertValue(paymentLinkStatusVO, PaymentLinkStatus.class));
	}

	@Override
	public PaymentLinkStatus findPaymentLinkStatusById(Integer id) {
		return paymentLinkStatusRepo.findById(id).get();
	}

	@Override
	public PaymentLinkStatus findPaymentLinkStatusByOrderId(Integer orderId) {
		return paymentLinkStatusRepo.findByorderId(orderId);
	}

	@Override
	public List<PaymentLinkStatus> getAllPaymentLinkStatus() {
		return paymentLinkStatusRepo.findAll();
	}

}
