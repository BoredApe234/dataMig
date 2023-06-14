package com.mps.think.setup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.setup.service.PaymentLinkStatusService;
import com.mps.think.setup.vo.PaymentLinkStatusVO;

@RestController
@CrossOrigin
public class PaymentLinkStatusController {

	@Autowired
	PaymentLinkStatusService linkStatusService;
	
	@PostMapping("/getAllPaymentLinkStatus")
	public ResponseEntity<?> getAllPaymentLinkStatus(@RequestBody Integer pubId){
		return ResponseEntity.ok(linkStatusService.getAllPaymentLinkStatus(pubId));
	}
	
	@PostMapping("/savePaymentLinkStatus")
	public ResponseEntity<?> savePaymentLinkStatus(@RequestBody PaymentLinkStatusVO paymentLinkStatusVO){
		return ResponseEntity.ok(linkStatusService.savePaymentLinkStatus(paymentLinkStatusVO));
	}
	
	@PostMapping("/updatePaymentLinkStatus")
	public ResponseEntity<?> updatePaymentLinkStatus(@RequestBody PaymentLinkStatusVO paymentLinkStatusVO){
		return ResponseEntity.ok(linkStatusService.updatePaymentLinkStatus(paymentLinkStatusVO));
	}
	
	@PostMapping("/findPaymentLinkStatusById")
	public ResponseEntity<?> findPaymentLinkStatusById(@RequestBody Integer id){
		return ResponseEntity.ok(linkStatusService.findPaymentLinkStatusById(id));
	}
	
	@PostMapping("/findPaymentLinkStatusByOrderId")
	public ResponseEntity<?> findPaymentLinkStatusByOrderId(@RequestBody Integer orderId){
		return ResponseEntity.ok(linkStatusService.findPaymentLinkStatusByOrderId(orderId));
	}
}
