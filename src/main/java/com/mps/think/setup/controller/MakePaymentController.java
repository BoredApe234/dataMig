package com.mps.think.setup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.setup.service.MakePaymentService;
import com.mps.think.setup.vo.MailTemplateVO;
import com.mps.think.setup.vo.MakePaymentVO;
@RestController
@CrossOrigin
public class MakePaymentController {
	
	@Autowired
	MakePaymentService makePaymentService;
	
	@PostMapping("/findAllMakePaymentForPublisher")
	public ResponseEntity<?> findAllMakePaymentForPublisher(@RequestBody Integer pubId){
		return ResponseEntity.ok(makePaymentService.findAllMakePaymentByPubId(pubId));
	}
	
	@PostMapping("/saveMakePayment")
	public ResponseEntity<?> saveMakePayment(@RequestBody MakePaymentVO makePaymentVO){
		return ResponseEntity.ok(makePaymentService.saveMakePayment(makePaymentVO));
	}
	
	@PostMapping("/updateMakePayment")
	public ResponseEntity<?> updateMakePayment(@RequestBody MakePaymentVO makePaymentVO){
		return ResponseEntity.ok(makePaymentService.updateMakePayment(makePaymentVO));
	}

	@PostMapping("/findMakePaymentId")
	public ResponseEntity<?> findMakePaymentId(@RequestBody Integer id){
		return ResponseEntity.ok(makePaymentService.findByMakePaymentId(id));
	}
	
	@PostMapping("/sendPaymentLink")
	public ResponseEntity<?> sendPaymentLink(@RequestBody MailTemplateVO mailTemplateVO) {
		return ResponseEntity.ok(makePaymentService.sendPaymentLink(mailTemplateVO));
	}
}
