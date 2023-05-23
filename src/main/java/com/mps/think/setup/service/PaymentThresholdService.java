package com.mps.think.setup.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import com.mps.think.setup.model.PaymentThreshold;
import com.mps.think.setup.vo.PaymentThresholdVO;

public interface PaymentThresholdService {

	public List<PaymentThreshold> getAllPaymentThresholdForPublisher(Integer pubId);
	
	public PaymentThreshold savePaymentThreshold(PaymentThresholdVO paymentThresholdVO);
	
	public PaymentThreshold updatePaymentThreshold(PaymentThresholdVO paymentThresholdVO);
	
	public Optional<PaymentThreshold> findByPaymentThresholdId(Integer id);
	
	public HashMap<String, String> definePayment(double invoiceAmount, double paidAmount, Integer paymentThresholdId);
	
	public PaymentThreshold findByPaymentThresholdDefId(Integer id);
}
