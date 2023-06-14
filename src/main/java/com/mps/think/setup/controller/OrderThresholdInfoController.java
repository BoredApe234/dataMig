package com.mps.think.setup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.setup.service.OrderThresholdInfoService;
import com.mps.think.setup.vo.OrderThresholdInfoVO;

@RestController
@CrossOrigin
public class OrderThresholdInfoController {
	
	@Autowired
	OrderThresholdInfoService thresholdInfoService;
	
	@PostMapping("/findAllorderThresholdByPubId")
	public ResponseEntity<?> findAllorderThresholdByPubId(@RequestBody Integer pubId) {
		return ResponseEntity.ok(thresholdInfoService.findAllorderThresholdByPubId(pubId));
	}
	
	@PostMapping("/saveorderThresholdInfo")
	public ResponseEntity<?> saveorderThresholdInfo(@RequestBody List<OrderThresholdInfoVO> orderThresholdInfoVO) {
		return ResponseEntity.ok(thresholdInfoService.saveorderThresholdInfo(orderThresholdInfoVO));
	}
	
	@PostMapping("/findbyOrderId")
	public ResponseEntity<?> findbyOrderId(@RequestBody Integer orderId) {
		return ResponseEntity.ok(thresholdInfoService.findbyOrderId(orderId));
	}
	
}
