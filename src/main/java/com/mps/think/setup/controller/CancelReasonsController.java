package com.mps.think.setup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.setup.service.CancelReasonsService;
import com.mps.think.setup.vo.CancelReasonsVO;



@RestController
@CrossOrigin
public class CancelReasonsController {
	
	@Autowired
	CancelReasonsService cancelReasonsService;
	
	@GetMapping("/getAllCancelReasons")
	public ResponseEntity<?> getAllCancelReasons() {
		return ResponseEntity.ok(cancelReasonsService.findAllCancelReasons());
	}

	@PostMapping("/saveCancelReasons")
	public ResponseEntity<?> savecancelReasons(@RequestBody CancelReasonsVO Id) {
		return ResponseEntity.ok(cancelReasonsService.saveCancelReasons(Id));
	}
	
	@PostMapping("/updateCancelReasons")
	public ResponseEntity<?> updatecancelReasons(@RequestBody CancelReasonsVO Id) {
		return ResponseEntity.ok(cancelReasonsService.updateCancelReasons(Id));
	}
	
	@PostMapping("/findbyCancelReasonsId")
	public ResponseEntity<?> findbyCancelReasonsId(@RequestBody Integer cancelReasonsId) {
		return ResponseEntity.ok(cancelReasonsService.findbyCancelReasonsId(cancelReasonsId));
	}
	
	@PostMapping("/findbyPubId")
	public ResponseEntity<?> findbyPubId(@RequestBody Integer pubId) {
		return ResponseEntity.ok(cancelReasonsService.findByPubId(pubId));
	}
	
	@DeleteMapping("/deleteByCrId")
	public ResponseEntity<?> deleteByCancelReasonsId(@RequestBody Integer cancelReasonsId) {
		return ResponseEntity.ok(cancelReasonsService.deleteByCancelReasonsId(cancelReasonsId));
	}

}
