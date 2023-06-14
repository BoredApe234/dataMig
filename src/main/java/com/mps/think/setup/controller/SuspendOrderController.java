package com.mps.think.setup.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.setup.service.SuspendOrderService;
import com.mps.think.setup.serviceImpl.SuspendOrderServiceImpl;
import com.mps.think.setup.vo.SuspendOrderVO;

@CrossOrigin
@RestController
public class SuspendOrderController {

	@Autowired
	SuspendOrderService suspendOrderService;
	
//	@Autowired
//	SuspendOrderServiceImpl imp;
	
	@PostMapping("/saveSuspendOrdersDetails")
	public ResponseEntity<?> saveSuspendOrdersDetails(@RequestBody SuspendOrderVO suspendOrder) {
		return ResponseEntity.ok(suspendOrderService.saveSuspendOrdersDetail(suspendOrder));
	}

//	@PostMapping("/checkSuspension")
//	public String suspendOrder(){
//		sus.checkOrdersToSuspend();
//		return "good";
//	}
//	
//	@PostMapping("/continueOrders")
//	public String continueOrders() throws ParseException {
//		sus.checkOrdersToContinue();
//		return "good";
//	}

	@GetMapping("/getAllOrdersByIdWithSuspensionDetails/{orderId}")
	public ResponseEntity<?> getAllOrdersByIdWithSuspensionDetails(@PathVariable("orderId") Integer orderId,
			@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer size) {
		return ResponseEntity.ok(suspendOrderService.findOrdersByIdWithSuspensionDetails(orderId, PageRequest.of(page, size)));
	}

//	@GetMapping("/getAllSus")
//	public ResponseEntity<?> getAllSus() {
//		return ResponseEntity.ok(imp.getAllSuspensions());
//	}

}
