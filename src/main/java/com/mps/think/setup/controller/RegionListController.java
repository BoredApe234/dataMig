package com.mps.think.setup.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mps.think.setup.service.RegionListService;
import com.mps.think.setup.vo.RegionListVO;
import com.mps.think.setup.vo.EnumModelVO.AddressValidation;
import com.mps.think.setup.vo.EnumModelVO.TaxComputation;

@RestController
@CrossOrigin
public class RegionListController {
	
	@Autowired
	private RegionListService regionListService;
	
	@GetMapping("/getAllRegionList")
	public ResponseEntity<?> getAllInserts() {
		return ResponseEntity.ok(regionListService.getAllRegionList());
	}
	
	@PostMapping("/saveRegionList")
	public ResponseEntity<?> saveInserts(@RequestBody RegionListVO id) {
		return ResponseEntity.ok(regionListService.saveRegionList(id));
	}
	
	@PostMapping("/updateRegionList")
	public ResponseEntity<?> updateInserts(@RequestBody RegionListVO id) {
		return ResponseEntity.ok(regionListService.updateRegionList(id));	
		}
	
	@PostMapping("/findbyRegionListId")
	public ResponseEntity<?> findbySplitsId(@RequestBody Integer id) {
		return ResponseEntity.ok(regionListService.findbyRegionListId(id));
	}
	
	@DeleteMapping("/deletebyRegionListId")
	public ResponseEntity<?> deleteBySplitsId(@RequestBody Integer id) {
		return ResponseEntity.ok(regionListService.deleteByRegionListId(id));
	}
	
	@GetMapping("/findAllTaxComputationforregionlist")
	public ResponseEntity<?> getAllTaxComputation() {
		List<String> list= new ArrayList<>();
		for(TaxComputation data:TaxComputation.values()) {
			list.add(data.getTaxComputation());
		}
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/findAllAddressValidationforregionlist")
	public ResponseEntity<?> getAllAddressValidation() {
		List<String> list= new ArrayList<>();
		for(AddressValidation data:AddressValidation.values()) {
			list.add(data.getAddressValidation());
		}
		return ResponseEntity.ok(list);
	}
	
	

}
