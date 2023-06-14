package com.mps.think.setup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.setup.service.DateBasedOrderService;
import com.mps.think.setup.vo.DateBasedOrderVO;

@CrossOrigin
@RestController
public class DateBasedOrderController {

	@Autowired
	private DateBasedOrderService orderService;
	
	@PostMapping("/saveDateBasedSubscriptionOrder")
	public ResponseEntity<?> saveDateBasedSubscriptionOrder(@RequestBody DateBasedOrderVO order) throws Exception {
		return ResponseEntity.ok(orderService.saveDateBasedOrder(order));
	}
	
	@PutMapping("/updateDateBasedSubscriptionOrder")
	public ResponseEntity<?> updateDateBasedSubscriptionOrder(@RequestBody DateBasedOrderVO order) throws Exception {
		return ResponseEntity.ok(orderService.updateDateBasedOrder(order));
	}
	
	@GetMapping("/getAllDateBasedSubscriptionOrders")
	public ResponseEntity<?> getAllDateBasedSubscriptionOrders(@RequestParam(required = false) Integer publisherId, 
			@RequestParam(required = false) Integer customerId, @RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "5") Integer size) {
		return ResponseEntity.ok(orderService.findAllDateBasedOrders(publisherId, customerId, PageRequest.of(page, size)));
	}
	
}
