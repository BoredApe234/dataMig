package com.mps.think.setup.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.PaymentInformation;
import com.mps.think.setup.repo.PaymentInformationRepo;
import com.mps.think.setup.service.PaymentInformationService;
import com.mps.think.setup.vo.PaymentInformationVO;

@Service
public class PaymentInformationServiceImpl implements PaymentInformationService {

	@Autowired
	PaymentInformationRepo paymentInformationRepo;

	@Override
	public List<PaymentInformation> getallPaymentinFormationForPublisher(Integer pub) {
		return paymentInformationRepo.findByPublisherId(pub);
	}

	@Override
	public PaymentInformation savePayInfo(PaymentInformationVO paymentInformationVO) {
		ObjectMapper mapper = new ObjectMapper();
		PaymentInformation payInfo = mapper.convertValue(paymentInformationVO, PaymentInformation.class);
		PaymentInformation cdata = paymentInformationRepo.saveAndFlush(payInfo);
		return cdata;
	}

	@Override
	public Optional<PaymentInformation> findByPaymentInfoId(Integer id) {
		return paymentInformationRepo.findById(id);
	}

}
