package com.mps.think.setup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.setup.service.ProductInformationService;
import com.mps.think.setup.vo.ProductInformationVO;

@RestController
@CrossOrigin
public class ProductInformationController {

	@Autowired
	ProductInformationService productInformationService;
	
	@GetMapping("/getAllProductInformation")
	public ResponseEntity<?> getAllProductInformation(@RequestParam Integer pubId){
		return ResponseEntity.ok(productInformationService.getAllProductInformation(pubId));
	}
	
	@PostMapping("/saveProductInformation")
	public ResponseEntity<?> saveProductInformation(@RequestBody ProductInformationVO productInformationVO){
		return ResponseEntity.ok(productInformationService.saveProductInformation(productInformationVO));
	}
	
	@PostMapping("/updateProductInformation")
	public ResponseEntity<?> updateProductInformation(@RequestBody ProductInformationVO productInformationVO){
		return ResponseEntity.ok(productInformationService.updateProductInformation(productInformationVO));
	}
	
	@GetMapping("/findByProductInformationId")
	public ResponseEntity<?> findByProductInformationId(@RequestParam Integer id){
		return ResponseEntity.ok(productInformationService.findByProductInformationId(id));
	}
}
