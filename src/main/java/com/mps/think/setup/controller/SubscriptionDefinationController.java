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

import com.mps.think.setup.service.SubscriptionDefKeyInfoService;
import com.mps.think.setup.vo.SubscriptionDefKeyInfoVO;

@RestController
@CrossOrigin
public class SubscriptionDefinationController {

	@Autowired
	private SubscriptionDefKeyInfoService subscriptionDefService;
	
	@PostMapping("/saveSubscriptionDefination")
	public ResponseEntity<?> saveSubscriptionDefination(@RequestBody SubscriptionDefKeyInfoVO subscriptionDefination) {
		return ResponseEntity.ok(subscriptionDefService.saveSubscriptionDef(subscriptionDefination));
	}
	
	@PutMapping("/updateSubscriptionDefination")
	public ResponseEntity<?> updateSubscriptionDefination(@RequestBody SubscriptionDefKeyInfoVO subscriptionDefination) {
		return ResponseEntity.ok(subscriptionDefService.updateSubscriptionDef(subscriptionDefination));
	}
	
	@PostMapping("/getAllSubscriptionDefinationsForpublisher")
	public ResponseEntity<?> getAllSubscriptionDefinationsForpublisher(@RequestBody Integer publisherId) {
		return ResponseEntity.ok(subscriptionDefService.getSubscriptionDefByPublisherId(publisherId));
	}
	
	@DeleteMapping("deleteSubscriptionDefination")
	public ResponseEntity<?> deleteSubscriptionDefination(@RequestBody Integer id) {
		return ResponseEntity.ok(subscriptionDefService.deleteSubscriptionDef(id));
	}
	
	@GetMapping("subscriptionDefinationsByOcId/{ocId}")
	public ResponseEntity<?> getSubscriptionDefinationByOcId(@PathVariable("ocId") Integer ocId) {
		return ResponseEntity.ok(subscriptionDefService.getSubscriptionDefByOcId(ocId));
	}
	
	@GetMapping("allSubscriptionDefinations")
	public ResponseEntity<?> getAllSubscriptionDefinations() {
		return ResponseEntity.ok(subscriptionDefService.getAllSubscriptionDef());
	}
	
	@GetMapping("subscriptionDefinationsById/{id}")
	public ResponseEntity<?> getSubscriptionDefinationById(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(subscriptionDefService.getSubscriptionDefById(id));
	}
	
	@GetMapping("/allSuscriptionsForOrderCode/{orderCodeId}")
	public ResponseEntity<?> getSubscriptionsByOrderCode(@PathVariable("orderCodeId") Integer orderCodeId) {
		return ResponseEntity.ok(subscriptionDefService.getAllSubscriptionsByOrderCode(orderCodeId));
	}
	
}
