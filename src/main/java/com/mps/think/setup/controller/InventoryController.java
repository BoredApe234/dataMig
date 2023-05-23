package com.mps.think.setup.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.setup.service.InventoryService;
import com.mps.think.setup.vo.InventoryMapperVO;

@RestController
@CrossOrigin
public class InventoryController {
	
	@Autowired
	private InventoryService inventoryService;
	
	@GetMapping("/inventory")
	public ResponseEntity<?> getAllInventory() {
		return ResponseEntity.ok(inventoryService.getAllInventory());
	}
	
	@GetMapping("/inventory/{inventoryId}")
	public ResponseEntity<?> getInventoryById(@PathVariable Integer inventoryId) {
		return ResponseEntity.ok(inventoryService.getInventoryById(inventoryId));
	}
	
	@PostMapping("/inventory")
	public ResponseEntity<?> saveInventory(@Valid @RequestBody InventoryMapperVO inventory) {
		return ResponseEntity.ok(inventoryService.saveInventory(inventory));
	}
	
	@PutMapping("/inventory")
	public ResponseEntity<?> updateInventory(@Valid @RequestBody InventoryMapperVO inventory) {
		return ResponseEntity.ok(inventoryService.updateInventory(inventory));
	}

}
