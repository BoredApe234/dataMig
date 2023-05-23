package com.mps.think.setup.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mps.think.setup.model.PaymentType;
import com.mps.think.setup.vo.PaymentTypeVO;

public interface PaymentTypeService {

	PaymentType savePaymentType(PaymentTypeVO paymentType);
	
	PaymentType updatePaymentType(PaymentTypeVO updatePayment);
	
	Page<PaymentType> getAllPaymentTypes(Pageable page);
	
	PaymentType getPaymentTypeById(Integer paymentTypeId);
	
	PaymentType deletePaymentType(Integer paymentTypeId);
	
	List<String> getAllRealiseCashWhenValues();
	
	List<String> getAllCvvValues();
	
	Page<PaymentType> getAllPaymentTypeByPubId(Integer publisherId, Pageable page);
	
}
