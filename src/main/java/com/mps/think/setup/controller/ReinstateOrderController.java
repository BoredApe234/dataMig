package com.mps.think.setup.controller;

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

import com.mps.think.setup.service.ReinstateOrderService;
import com.mps.think.setup.serviceImpl.ReinstateOrderServiceImpl;
import com.mps.think.setup.vo.ReinstateOrderVO;

@RestController
@CrossOrigin
public class ReinstateOrderController {

	@Autowired
	private ReinstateOrderService reinstateOrderService;
	
//	@Autowired
//	ReinstateOrderServiceImpl imp;
	
	@PostMapping("/saveReinstateOrdersDetail")
	public ResponseEntity<?> saveReinstateOrdersDetail(@RequestBody ReinstateOrderVO reinstateOrder) {
		return ResponseEntity.ok(reinstateOrderService.saveReinstateOrderDetailsAndReinstateOrders(reinstateOrder));
	}
	
	@GetMapping("/getAllOrdersToReinstateByOrderId/{orderId}")
	public ResponseEntity<?> getAllOrdersToReinstateByOrderId(@PathVariable("orderId") Integer orderId, 
			@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer size) {
		return ResponseEntity.ok(reinstateOrderService.getAllOrdersToReinstateByOrderId(orderId, PageRequest.of(page, size)));
	}
	
//	@GetMapping("/getAllReins")
//	public ResponseEntity<?> getAllReins() {
//		return ResponseEntity.ok(imp.findAllReintate());
//	}
	
}
