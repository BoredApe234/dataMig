package com.mps.think.setup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.setup.service.PaymentThresholdService;
import com.mps.think.setup.vo.PaymentThresholdVO;
@RestController
@CrossOrigin
public class PaymentThresholdController {
	
	@Autowired
	PaymentThresholdService paymentThresholdService;
	
	@PostMapping("/getAllPaymentThresholdForPublisher")
	public ResponseEntity<?> getAllPaymentThresholdForPublisher(@RequestBody Integer pubId){
		return ResponseEntity.ok(paymentThresholdService.getAllPaymentThresholdForPublisher(pubId));
	}
	
	@PostMapping("/savePaymentThreshold")
	public ResponseEntity<?> savePaymentThreshold(@RequestBody PaymentThresholdVO paymentThresholdVO){
		return ResponseEntity.ok(paymentThresholdService.savePaymentThreshold(paymentThresholdVO));
	}
	
	@PostMapping("/updatePaymentThreshold")
	public ResponseEntity<?> updatePaymentThreshold(@RequestBody PaymentThresholdVO paymentThresholdVO){
		return ResponseEntity.ok(paymentThresholdService.updatePaymentThreshold(paymentThresholdVO));
	}
	
	@PostMapping("/getPaymentThresholdById")
	public ResponseEntity<?> getPaymentThresholdById(@RequestBody Integer id){
		return ResponseEntity.ok(paymentThresholdService.findByPaymentThresholdId(id));
	}
	
	@PostMapping("/getPaymentRange")
	public ResponseEntity<?> getPaymentRange(@RequestParam double invoiceAmount,@RequestParam double paidAmount,@RequestParam Integer paymentThresholdId){
		return ResponseEntity.ok(paymentThresholdService.definePayment(invoiceAmount, paidAmount, paymentThresholdId));
	}
	
	@PostMapping("/getPaymentThresholdDefId")
	public ResponseEntity<?> findByPaymentThresholdDefId(@RequestBody Integer id){
		return ResponseEntity.ok(paymentThresholdService.findByPaymentThresholdDefId(id));
	}

}
