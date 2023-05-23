package com.mps.think.setup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.setup.service.PaymentTypeService;
import com.mps.think.setup.vo.PaymentTypeVO;

@RestController
@CrossOrigin
public class PaymentTypeController {

	@Autowired
	private PaymentTypeService paymentTypeService;
	
	@PostMapping("/savePaymentType")
	public ResponseEntity<?> savePaymentType(@RequestBody PaymentTypeVO paymentType) {
		return ResponseEntity.ok(paymentTypeService.savePaymentType(paymentType));
	}
	
	@PutMapping("/updatePaymentType")
	public ResponseEntity<?> updatePaymentType(@RequestBody PaymentTypeVO paymentType) {
		return ResponseEntity.ok(paymentTypeService.updatePaymentType(paymentType));
	}
	
	@GetMapping("/getAllPaymentTypes")
	public ResponseEntity<?> getAllPaymentTypes(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer size) {
		return ResponseEntity.ok(paymentTypeService.getAllPaymentTypes(PageRequest.of(page, size)));
	}
	
	@PostMapping("/getAllPaymentTypesByPubId")
	public ResponseEntity<?> getAllPaymentTypesByPubId(@RequestParam(required = true) Integer publisherId, 
			@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer size) {
		return ResponseEntity.ok(paymentTypeService.getAllPaymentTypeByPubId(publisherId, PageRequest.of(page, size)));
	}
	
	@GetMapping("/getPaymentTypeById/{paymentTypeId}")
	public ResponseEntity<?> getPaymentTypeById(@PathVariable("paymentTypeId") Integer paymentTypeId) {
		return ResponseEntity.ok(paymentTypeService.getPaymentTypeById(paymentTypeId));
	}
	
	@DeleteMapping("/deletePaymentType")
	public ResponseEntity<?> deletePaymentType(@RequestBody Integer paymentTypeId) {
		return ResponseEntity.ok(paymentTypeService.deletePaymentType(paymentTypeId));
	}
	
	@GetMapping("getAllRealiseCashWhenValues")
	public ResponseEntity<?> getAllRealiseCashWhenValues() {
		return ResponseEntity.ok(paymentTypeService.getAllRealiseCashWhenValues());
	}
	
	@GetMapping("/getAllCvvValues")
	public ResponseEntity<?> getAllCvvValues() {
		return ResponseEntity.ok(paymentTypeService.getAllCvvValues());
	}
	
}
