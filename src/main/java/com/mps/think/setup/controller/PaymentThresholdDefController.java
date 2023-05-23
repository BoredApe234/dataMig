package com.mps.think.setup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.setup.service.PaymentThresholdDefService;
import com.mps.think.setup.vo.PaymentThresholdDefVO;

@RestController
@CrossOrigin
public class PaymentThresholdDefController {
	@Autowired
	PaymentThresholdDefService paymentThresholdDefService;
	
	@PostMapping("/findAllPaymentThresholdDef")
	public ResponseEntity<?> findAllPaymentThresholdDef(@RequestBody Integer pubId) {
		return ResponseEntity.ok(paymentThresholdDefService.getAllPaymentThresholdDefForPublisher(pubId));
	}

	@PostMapping("/savePaymentThresholdDef")
	public ResponseEntity<?> savePaymentThresholdDef(@RequestBody PaymentThresholdDefVO paymentThresholdDefVO) {
		return ResponseEntity.ok(paymentThresholdDefService.savePaymentThresholdDef(paymentThresholdDefVO));
	}
	
	@PostMapping("/updatePaymentThresholdDef")
	public ResponseEntity<?> updatePaymentThresholdDef(@RequestBody PaymentThresholdDefVO paymentThresholdDefVO) {
		return ResponseEntity.ok(paymentThresholdDefService.updatePaymentThresholdDef(paymentThresholdDefVO));
	}
	
	@PostMapping("/findbyPaymentThresholdDefId")
	public ResponseEntity<?> findbyPaymentThresholdDefId(@RequestBody Integer id) {
		return ResponseEntity.ok(paymentThresholdDefService.findbyPaymentThresholdDefId(id));
	}
	
	@DeleteMapping("/DeletePaymentThresholdDef")
	public ResponseEntity<?> DeletePaymentThresholdDef(@RequestBody Integer id) {
		return ResponseEntity.ok(paymentThresholdDefService.DeletePaymentThresholdDef(id));
	}

}
