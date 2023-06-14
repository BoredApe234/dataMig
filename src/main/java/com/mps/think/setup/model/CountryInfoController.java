package com.mps.think.setup.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mps.think.setup.service.CountryInfoService;

@RestController
@CrossOrigin
public class CountryInfoController {
	
	@Autowired
	CountryInfoService countryInfoService;
	
	@GetMapping("/getAllnames")
	public ResponseEntity<?> getAllName() {
		return ResponseEntity.ok(countryInfoService.getAllName());
	}

}
