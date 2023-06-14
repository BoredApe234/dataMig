package com.mps.think.setup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.setup.service.AutoRenewalService;
import com.mps.think.setup.vo.AutoRenewalVO;


@RestController
@CrossOrigin
public class AutoRenewalController {
	
	@Autowired
	private AutoRenewalService autoRenewalService;
	
	@GetMapping("/getAllAutoRenewal")
	public ResponseEntity<?> getAllAutoRenewal() {
		return ResponseEntity.ok(autoRenewalService.getAllAutoRenewal());
	}
	
	@PostMapping("/saveAutoRenewal")
	public ResponseEntity<?> saveAutoRenewal(@RequestBody AutoRenewalVO id) {
		return ResponseEntity.ok(autoRenewalService.saveAutoRenewal(id));
	}
	
	@PostMapping("/updateAutoRenewal")
	public ResponseEntity<?> updateAutoRenewal(@RequestBody AutoRenewalVO id) {
		return ResponseEntity.ok(autoRenewalService.updateAutoRenewal(id));	}
	
	@PostMapping("/findbyAutoRenewalId")
	public ResponseEntity<?> findbyAutoRenewalId(@RequestBody Integer id) {
		return ResponseEntity.ok(autoRenewalService.findbyAutoRenewalId(id));
	}
	
	@DeleteMapping("/deletebyAutoRenewalId")
	public ResponseEntity<?> deleteByAutoRenewalId(@RequestBody Integer id) {
		return ResponseEntity.ok(autoRenewalService.deleteByAutoRenewalId(id));
	}

}
