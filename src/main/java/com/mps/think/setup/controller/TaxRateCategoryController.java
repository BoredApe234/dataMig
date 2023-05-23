package com.mps.think.setup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.setup.service.TaxRateCategoryService;
import com.mps.think.setup.vo.TaxRateCategoryVO;

@RestController
@CrossOrigin
public class TaxRateCategoryController {

	@Autowired
	TaxRateCategoryService taxRateCategoryService;
	
	@GetMapping("/getAllTaxRateCategory")
	public ResponseEntity<?> getAllPubliser(){
		return ResponseEntity.ok(taxRateCategoryService.findAllTaxRateCategory());
	}

	@PostMapping("/saveTaxRateCategory")
	public ResponseEntity<?> saveTaxRateCategory(@RequestBody TaxRateCategoryVO Id){
		return ResponseEntity.ok(taxRateCategoryService.saveTaxRateCategory(Id));
	}

	@PostMapping("/updateTaxRateCategory")
	public ResponseEntity<?> updateTaxRateCategory(@RequestBody TaxRateCategoryVO id){
		return ResponseEntity.ok(taxRateCategoryService.updateTaxRateCategory(id));
	}

	@PostMapping("/findbyTaxRateCategoryId")
	public ResponseEntity<?> findbyId(@RequestBody Integer id){
		return ResponseEntity.ok(taxRateCategoryService.findbyTaxRateCategoryId(id));
	}
	
	@DeleteMapping("/deleteByTaxRateCategoryId")
	public ResponseEntity<?> deleteByTaxRateCategoryId(@RequestBody Integer id) {
		return ResponseEntity.ok(taxRateCategoryService.deleteByTaxRateCategoryId(id));
	}

	@PostMapping("/getAllTaxRateCategoriesForPublisher")
	public ResponseEntity<?> findAllTaxRateCategoriesForPublisher(@RequestBody Integer pubId) {
		return ResponseEntity.ok(taxRateCategoryService.findAllTaxRateCategoryForPublisher(pubId));
	}
	
}
