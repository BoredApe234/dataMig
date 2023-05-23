package com.mps.think.setup.service;

import java.util.List;

import com.mps.think.setup.model.PaymentThresholdDef;
import com.mps.think.setup.vo.PaymentThresholdDefVO;

public interface PaymentThresholdDefService {
	
	public List<PaymentThresholdDef> getAllPaymentThresholdDefForPublisher(Integer pubId);
	
	public PaymentThresholdDef savePaymentThresholdDef(PaymentThresholdDefVO paymentThresholdDefVO);
	
	public PaymentThresholdDef updatePaymentThresholdDef(PaymentThresholdDefVO paymentThresholdDefVO);
	
	public PaymentThresholdDef findbyPaymentThresholdDefId(Integer id);
	
	public PaymentThresholdDef DeletePaymentThresholdDef(Integer id);

}
