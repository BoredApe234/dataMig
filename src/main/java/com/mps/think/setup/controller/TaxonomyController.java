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

import com.mps.think.setup.service.TaxonomyService;
import com.mps.think.setup.vo.TaxonomyVO;

@RestController
@CrossOrigin
public class TaxonomyController {
	
	@Autowired
	TaxonomyService taxonomyService;
	
	@GetMapping("/getAllTaxonomy")
	public ResponseEntity<?> getAllTaxonomy() {
		return ResponseEntity.ok(taxonomyService.findAllTaxonomy());
	}

	@PostMapping("/saveTaxonomy")
	public ResponseEntity<?> savetaxonomy(@RequestBody TaxonomyVO taxonomy) {
		return ResponseEntity.ok(taxonomyService.saveTaxonomy(taxonomy));
	}
	
	@PostMapping("/updateTaxonomy")
	public ResponseEntity<?> updatetaxonomy(@RequestBody TaxonomyVO taxonomy) {
		return ResponseEntity.ok(taxonomyService.updateTaxonomy(taxonomy));
	}
	
	@PostMapping("/findbyTaxonomyId")
	public ResponseEntity<?> findbyTaxonomyId(@RequestBody Integer id) {
		return ResponseEntity.ok(taxonomyService.findbyId(id));
	}
	
	
	@DeleteMapping("/deleteTaxonomyById")
	public ResponseEntity<?> deleteById(@RequestBody Integer id) {
		return ResponseEntity.ok(taxonomyService.deleteById(id));
	}
	
	@PostMapping("getAllTaxonomyForPublisher")
	public ResponseEntity<?> getAllTaxonomyForPublisher( @RequestBody Integer publisherId) {
		return ResponseEntity.ok(taxonomyService.findAllTaxonomyByPubId(publisherId));
	}

}
