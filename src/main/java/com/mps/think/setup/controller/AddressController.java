package com.mps.think.setup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mps.think.setup.service.AddressessService;
import com.mps.think.setup.vo.AddressVO;

@RestController
@CrossOrigin
public class AddressController {
	
	@Autowired
	AddressessService addressService;

	@GetMapping("/getAllAddress")
	public ResponseEntity<?> getAllAddress() {
		return ResponseEntity.ok(addressService.getAllAddress());
	}

	@PostMapping("/saveAddress")
	public ResponseEntity<?> saveAddress(@RequestBody AddressVO id) {
		return ResponseEntity.ok(addressService.saveAddress(id));
	}

	@PostMapping("/updateAddress")
	public ResponseEntity<?> updateAddress(@RequestBody AddressVO id) {
		return ResponseEntity.ok(addressService.updateAddress(id));
	}

	@PostMapping("/findbyAddressId")
	public ResponseEntity<?> findbyAddressId(@RequestBody Integer id) {
		return ResponseEntity.ok(addressService.findbyAddressId(id));
	}

	@DeleteMapping("/deleteByAddressId")
	public ResponseEntity<?> deleteByAddressId(@RequestBody Integer id) {
		return ResponseEntity.ok(addressService.deleteByAddressId(id));
	}

	@PostMapping("/getAllAddressForPublisher")
	public ResponseEntity<?> findAllAddressForPublisher(@RequestBody Integer pubId) {
		return ResponseEntity.ok(addressService.findAllAddressForPublisher(pubId));
	}

}
