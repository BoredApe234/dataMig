package com.mps.think.setup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.setup.service.OrderCodesService;
import com.mps.think.setup.vo.OrderCodesSuperVO;

@RestController
@CrossOrigin
public class OrderCodesController {
	
	@Autowired
	private OrderCodesService orderCodesService;
	
	@PostMapping("/getAllOrderCodesForpublisher")
	public ResponseEntity<?> getAllOrderCodesForpublisher(@RequestBody Integer publisherId) {
		return ResponseEntity.ok(orderCodesService.getOrderByPublisherId(publisherId));
	}
	
	@PostMapping("/orderCodes")
	public ResponseEntity<?> createOrderCodes(@RequestBody OrderCodesSuperVO orderCodes) {
		return ResponseEntity.ok(orderCodesService.saveOrderCodes(orderCodes));
	}
	
	@PutMapping("/orderCodes")
	public ResponseEntity<?> updateOrderCodes(@RequestBody OrderCodesSuperVO orderCodes) {
		return ResponseEntity.ok(orderCodesService.updateOrderCodes(orderCodes));
	}
	
	@GetMapping("/getOrderCodes/{orderCodeId}")
	public ResponseEntity<?> getOrderCodesById(@PathVariable("orderCodeId") Integer orderCodeID) {
		return ResponseEntity.ok(orderCodesService.getOrderCodesById(orderCodeID));
	}

	@GetMapping("/getOrderItemDetails/{itemDetailsId}")
	public ResponseEntity<?> getOrderItemDetailsById(Integer itemDetailsId) {
		return ResponseEntity.ok(orderCodesService.getOrderItemDetailsById(itemDetailsId));
	}
	

	@GetMapping("/getOrderOptions/{orderOptionsId}")
	public ResponseEntity<?> getOrderOptionsById(@PathVariable("orderOptionsId") Integer orderOptionsId) {
		return ResponseEntity.ok(orderCodesService.getOrderOptionsById(orderOptionsId));
	}

	@GetMapping("/getOrderPackageOptions/{orderPkgId}")
	public ResponseEntity<?> getOrderPackageOptionsById(@PathVariable("orderPkgId") Integer orderPkgId) {
		return ResponseEntity.ok(orderCodesService.getOrderPackageOptionsById(orderPkgId));
	}

	@GetMapping("/getOrderPaymentOptions/{orderPaymentId}")
	public ResponseEntity<?> getOrderPaymentOptionsById(@PathVariable("orderPaymentId") Integer orderPaymentId) {
		return ResponseEntity.ok(orderCodesService.getOrderPaymentOptionsById(orderPaymentId));
	}
	
	@GetMapping("/getOrderCodesRecord")
	public ResponseEntity<?> getAllOrderCodes() {
		return ResponseEntity.ok(orderCodesService.getAllOrderCodes());
	}
	
	@DeleteMapping("/deleteOrderCode")
	public ResponseEntity<?> deleteOrderCode(@RequestBody Integer id) {
		return ResponseEntity.ok(orderCodesService.deleteOrderCode(id));
	}
	
	@GetMapping("/getAllCompleteOrderCodes")
	public ResponseEntity<?> getAllCompleteOrderCodes() {
		return ResponseEntity.ok(orderCodesService.getAllCompleteOrderCodes());
	}
	
	@GetMapping("/getAllOrderCodesByOrderClassId/{ocId}")
	public ResponseEntity<?> getAllOrderCodesByOrderClassId(@PathVariable("ocId") Integer ocId) {
		return ResponseEntity.ok(orderCodesService.getAllOrderCodesByOrderClassId(ocId));
	}
	
	@GetMapping("/getAllTermsInOrderCodeSubsDefById/{orderCodeId}")
	public ResponseEntity<?> getAllTermsUnderOrderCode(@PathVariable("orderCodeId") Integer orderCodeId) {
		return ResponseEntity.ok(orderCodesService.getAllTermsForOrderCodeByIdOrderCodeId(orderCodeId));
	}
	

}
