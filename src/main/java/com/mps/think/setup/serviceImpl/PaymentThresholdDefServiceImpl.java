package com.mps.think.setup.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.DeliveryMethods;
import com.mps.think.setup.model.PaymentThresholdDef;
import com.mps.think.setup.repo.PaymentThresholdDefRepo;
import com.mps.think.setup.service.PaymentThresholdDefService;
import com.mps.think.setup.vo.PaymentThresholdDefVO;
@Service
public class PaymentThresholdDefServiceImpl implements PaymentThresholdDefService{
	@Autowired
	PaymentThresholdDefRepo paymentThresholdDefRepo;

	@Override
	public List<PaymentThresholdDef> getAllPaymentThresholdDefForPublisher(Integer pubId) {
		return paymentThresholdDefRepo.findByPublisherId(pubId);
	}

	@Override
	public PaymentThresholdDef savePaymentThresholdDef(PaymentThresholdDefVO paymentThresholdDefVO) {
		ObjectMapper mapper = new ObjectMapper();
		PaymentThresholdDef newThreshold = mapper.convertValue(paymentThresholdDefVO, PaymentThresholdDef.class);
		PaymentThresholdDef cdata=paymentThresholdDefRepo.saveAndFlush(newThreshold);
		return cdata;
	}

	@Override
	public PaymentThresholdDef updatePaymentThresholdDef(PaymentThresholdDefVO paymentThresholdDefVO) {
		ObjectMapper mapper = new ObjectMapper();
		PaymentThresholdDef newThreshold = mapper.convertValue(paymentThresholdDefVO, PaymentThresholdDef.class);
		PaymentThresholdDef cdata=paymentThresholdDefRepo.saveAndFlush(newThreshold);
		return cdata;
	}

	@Override
	public PaymentThresholdDef findbyPaymentThresholdDefId(Integer id) {
		return paymentThresholdDefRepo.findById(id).get();
	}

	@Override
	public PaymentThresholdDef DeletePaymentThresholdDef(Integer id) {
		PaymentThresholdDef remove = paymentThresholdDefRepo.findById(id).get();
		if (remove != null) {
			paymentThresholdDefRepo.delete(remove);
		}
		return remove;
	}

}
