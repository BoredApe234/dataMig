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

import com.mps.think.setup.service.OrderClassOverviewService;
import com.mps.think.setup.vo.OrderClassOverviewVO;

@RestController
@CrossOrigin
public class OrderClassOverviewController {

	@Autowired
	private OrderClassOverviewService orderClassOverviewService;
	
	@PostMapping("/saveOrderClassOverview")
	public ResponseEntity<?> saveOrderClassOverview(@RequestBody OrderClassOverviewVO overview) {
		return ResponseEntity.ok(orderClassOverviewService.saveOrderClassOverview(overview));
	}
	
	@PutMapping("/updateOrderClassOverview")
	public ResponseEntity<?> updateOrderClassOverview(@RequestBody OrderClassOverviewVO overview) {
		return ResponseEntity.ok(orderClassOverviewService.updateOrderClassOverview(overview));
	}
	
	@DeleteMapping("/deleteOrderClassOverviewById")
	public ResponseEntity<?> deleteOrderClassOverviewById(@RequestBody Integer id) {
		return ResponseEntity.ok(orderClassOverviewService.deleteOrderClassOverviewById(id));
	}
	
	@GetMapping("findOrderClassOverviewById/{id}")
	public ResponseEntity<?> findOrderClassOverviewById(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(orderClassOverviewService.findOrderClassOverviewById(id));
	}
	
	@GetMapping("/findOrderClassOverviewByPubId/{pubId}")
	public ResponseEntity<?> findOrderClassOverviewByPubId(@PathVariable("pubId") Integer pubId) {
		return ResponseEntity.ok(orderClassOverviewService.getAllOrderClassOverviewByPubId(pubId));
	}
	
	@GetMapping("/findOrderClassOverviewByOcId/{ocId}")
	public ResponseEntity<?> findOrderClassOverviewByOcId(@PathVariable Integer ocId) {
		return ResponseEntity.ok(orderClassOverviewService.getAllOrderClassOverviewByOrderClassId(ocId));
	}
	
	@GetMapping("/findAllOrderClassOverview")
	public ResponseEntity<?> findAllOrderClassOverview() {
		return ResponseEntity.ok(orderClassOverviewService.getAllOrderClassOverview());
	}
	
}
