package com.mps.think.setup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.mps.think.setup.service.ValueForScAttributeService;

import com.mps.think.setup.vo.ValueForScAttributeVO;

@RestController
@CrossOrigin
public class ValueForScAttributeController {
	
	@Autowired
	ValueForScAttributeService valueForScAttributeService;
	
	@GetMapping("/getAllValueForScAttribute")
	public ResponseEntity<?> getAllvalueForScAttributeService() {
		return ResponseEntity.ok(valueForScAttributeService.findAllValueForScAttribute());
	}

	@PostMapping("/saveValueForScAttribute")
	public ResponseEntity<?> savevalueForScAttribute(@RequestBody ValueForScAttributeVO valueForScAttribute) {
		return ResponseEntity.ok(valueForScAttributeService.saveValueForScAttribute(valueForScAttribute));
	}
	
	@PostMapping("/updateValueForScAttribute")
	public ResponseEntity<?> updatevalueForScAttribute(@RequestBody ValueForScAttributeVO valueForScAttribute) {
		return ResponseEntity.ok(valueForScAttributeService.updateValueForScAttribute(valueForScAttribute));
	}
	
	@PostMapping("/findbyValueForScAttributeId")
	public ResponseEntity<?> findbyValueForScAttributeId(@RequestBody Integer id) {
		return ResponseEntity.ok(valueForScAttributeService.findbyId(id));
	}
	
	
	@DeleteMapping("/deleteValueForScAttributeById")
	public ResponseEntity<?> deleteById(@RequestBody Integer id) {
		return ResponseEntity.ok(valueForScAttributeService.deleteById(id));
	}

}
