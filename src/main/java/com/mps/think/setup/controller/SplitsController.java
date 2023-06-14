package com.mps.think.setup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mps.think.setup.service.SplitsService;
import com.mps.think.setup.vo.SplitsVO;

@RestController
@CrossOrigin
public class SplitsController {
	
	@Autowired
	private SplitsService splitsService;
	
	@GetMapping("/getAllSplits")
	public ResponseEntity<?> getAllSplits() {
		return ResponseEntity.ok(splitsService.getAllSplits());
	}
	
	@PostMapping("/saveSplits")
	public ResponseEntity<?> saveSplits(@RequestBody SplitsVO id) {
		return ResponseEntity.ok(splitsService.saveSplits(id));
	}
	
	@PostMapping("/updateSplits")
	public ResponseEntity<?> updateSplits(@RequestBody SplitsVO id) {
		return ResponseEntity.ok(splitsService.updateSplits(id));	}
	
	@PostMapping("/findbySplitsId")
	public ResponseEntity<?> findbySplitsId(@RequestBody Integer id) {
		return ResponseEntity.ok(splitsService.findbySplitsId(id));
	}
	
	@DeleteMapping("/deletebySplitsId")
	public ResponseEntity<?> deleteBySplitsId(@RequestBody Integer id) {
		return ResponseEntity.ok(splitsService.deleteBySplitsId(id));
	}

}
