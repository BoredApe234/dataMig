package com.mps.think.setup.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.PaymentType;
import com.mps.think.setup.repo.PaymentTypeRepo;
import com.mps.think.setup.service.PaymentTypeService;
import com.mps.think.setup.vo.EnumModelVO.CVVValues;
import com.mps.think.setup.vo.EnumModelVO.RealiseCashWhen;
import com.mps.think.setup.vo.PaymentTypeVO;

@Service
public class PaymentTypeServiceImpl implements PaymentTypeService {

	@Autowired
	private PaymentTypeRepo paymentTypeRepo;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Override
	public PaymentType savePaymentType(PaymentTypeVO paymentType) {
		PaymentType newPaymentType = mapper.convertValue(paymentType, PaymentType.class);
		return paymentTypeRepo.saveAndFlush(newPaymentType);
	}

	@Override
	public PaymentType updatePaymentType(PaymentTypeVO updatePayment) {
		PaymentType payment = mapper.convertValue(updatePayment, PaymentType.class);
		return paymentTypeRepo.saveAndFlush(payment);
	}

	@Override
	public Page<PaymentType> getAllPaymentTypes(Pageable page) {
		return paymentTypeRepo.findAll(page);
	}

	@Override
	public PaymentType getPaymentTypeById(Integer paymentTypeId) {
		Optional<PaymentType> paymentType = paymentTypeRepo.findById(paymentTypeId);
		if (paymentType.isPresent()) return paymentType.get();
		else throw new NoSuchElementException("No PaymentType with id: " + paymentTypeId + " exists");
	}

	@Override
	public PaymentType deletePaymentType(Integer paymentTypeId) {
		PaymentType paymentTypeById = getPaymentTypeById(paymentTypeId);
		paymentTypeRepo.delete(paymentTypeById);
		return paymentTypeById;
	}

	@Override
	public List<String> getAllRealiseCashWhenValues() {
		List<String> vals = new ArrayList<>();
		for (RealiseCashWhen val : RealiseCashWhen.values()) {
			vals.add(val.getRealiseCash());
		}
		return vals;
	}

	@Override
	public List<String> getAllCvvValues() {
		List<String> vals = new ArrayList<>();
		for(CVVValues val : CVVValues.values()) {
			vals.add(val.getCvv());
		}
		return vals;
	}

	@Override
	public Page<PaymentType> getAllPaymentTypeByPubId(Integer publisherId, Pageable page) {
		return paymentTypeRepo.findByPublisherIdOrderByIdDesc(publisherId, page);
	}

}
