package com.mps.think.setup.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mps.think.setup.service.CancelOrderService;
import com.mps.think.setup.vo.CancelOrderVO;
import com.mps.think.setup.vo.EnumModelVO.RefundTo;



@RestController
@CrossOrigin
public class CancelOrderController {
	
	@Autowired
	CancelOrderService cancelOrderService;
	
	@GetMapping("/getAllCancelOrder")
	public ResponseEntity<?> getAllCancelOrder() {
		return ResponseEntity.ok(cancelOrderService.getAllCancelOrder());
	}
	
	@PostMapping("/saveCancelOrder")
	public ResponseEntity<?> savecancelOrder(@RequestBody CancelOrderVO cancelOrderId) {
		return ResponseEntity.ok(cancelOrderService.saveCancelOrder(cancelOrderId));
	}
	
	@PostMapping("/findbyCancelOrderId")
	public ResponseEntity<?> findbyCancelOrderId(@RequestBody Integer cancelOrderId) {
		return ResponseEntity.ok(cancelOrderService.findbyCancelOrderId(cancelOrderId));
	}
	
	@PostMapping("/updateCancelOrder")
	public ResponseEntity<?> updatecancelOrder(@RequestBody CancelOrderVO cancelOrderId) {
		return ResponseEntity.ok(cancelOrderService.updateCancelOrder(cancelOrderId));
	}
	
	@PostMapping("/findAllCancelOrderByOrderId")
	public ResponseEntity<?> findByOrderidOrderId(@RequestBody Integer cancelOrderId) {
		return ResponseEntity.ok(cancelOrderService.getAllCancelOrderByCancelorderId(cancelOrderId));
	}
	
	@GetMapping("/findRefundTo")
	public ResponseEntity<?> getAllRefundTo() {
		List<String> list= new ArrayList<>();
		for(RefundTo data:RefundTo.values()) {
			list.add(data.getDisplayName());
		}
		return ResponseEntity.ok(list);
	}

}
