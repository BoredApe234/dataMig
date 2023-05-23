package com.mps.think.setup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.setup.service.PaymentInformationService;
import com.mps.think.setup.vo.PaymentInformationVO;

@RestController
@CrossOrigin
public class PaymentInformationController {

	@Autowired
	PaymentInformationService paymentInformationService;
	
	@PostMapping("/getAllPaymentInformation")
	public ResponseEntity<?> getAllPaymentInformation(@RequestBody Integer pubId){
		return ResponseEntity.ok(paymentInformationService.getallPaymentinFormationForPublisher(pubId));
	}
	
	@PostMapping("/savePaymentInformation")
	public ResponseEntity<?> savePaymentInformation(@RequestBody PaymentInformationVO paymentInformationVO){
		return ResponseEntity.ok(paymentInformationService.savePayInfo(paymentInformationVO));
	}
	
	@PostMapping("/findPaymentInformationById")
	public ResponseEntity<?> findPaymentInformationById(@RequestBody Integer id){
		return ResponseEntity.ok(paymentInformationService.findByPaymentInfoId(id));
	}
	
}
