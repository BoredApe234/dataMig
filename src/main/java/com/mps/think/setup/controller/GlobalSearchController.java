package com.mps.think.setup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.setup.service.GlobalSearchService;

@RestController
@CrossOrigin
public class GlobalSearchController {

//	@Autowired
//	private GlobalSearchService globalSearchService;
//	
//	@GetMapping("/getAllResults")
//	public ResponseEntity<?> getAllResults(@RequestParam(required = false) String keyword, 
//			@RequestParam(defaultValue = "0") Integer customerPageStart, @RequestParam(defaultValue = "5") Integer customerPageEnd) {
//		return ResponseEntity.ok(globalSearchService.getSearchResults(keyword, PageRequest.of(customerPageStart, customerPageEnd)));
//	}
	
}