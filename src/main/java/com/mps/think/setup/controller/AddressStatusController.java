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
import com.mps.think.setup.service.AddressStatusService;
import com.mps.think.setup.vo.AddressStatusVO;
import com.mps.think.setup.vo.EnumModelVO.Addressstatus;
import com.mps.think.setup.vo.EnumModelVO.SubDefStatus;

@RestController
@CrossOrigin
public class AddressStatusController {
	
	@Autowired
	private AddressStatusService addressStatusService;
	
	@GetMapping("/getAllAddressStatus")
	public ResponseEntity<?> getAllAddressStatus() {
		return ResponseEntity.ok(addressStatusService.getAllAddressStatus());
	}
	
	@PostMapping("/saveAddressStatus")
	public ResponseEntity<?> saveAddressStatus(@RequestBody AddressStatusVO id) {
		return ResponseEntity.ok(addressStatusService.saveAddressStatus(id));
	}
	
	@PostMapping("/updateAddressStatus")
	public ResponseEntity<?> updateAddressStatus(@RequestBody AddressStatusVO id) {
		return ResponseEntity.ok(addressStatusService.updateAddressStatus(id));	
		}
	
	@PostMapping("/findbypubId")
	public ResponseEntity<?> findAllAddressStatusByPubId(@RequestBody Integer id) {
		return ResponseEntity.ok(addressStatusService.findAllAddressStatusByPubId(id));
	}
	
	@PostMapping("/findbyAddressStatusId")
	public ResponseEntity<?> findbyAddressStatusId(@RequestBody Integer id) {
		return ResponseEntity.ok(addressStatusService.findbyAddressStatusId(id));
	}
	
	@DeleteMapping("/deletebyAddressStatusId")
	public ResponseEntity<?> deleteByAddressStatusId(@RequestBody Integer id) {
		return ResponseEntity.ok(addressStatusService.deleteByAddressStatusId(id));
	}
	
	@GetMapping("/findAllStatus")
	public ResponseEntity<?> getAllSubDefStatus() {
		List<String> list= new ArrayList<>();
		for(SubDefStatus data:SubDefStatus.values()) {
			list.add(data.getStatus());
		}
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/findAllAddressstatus")
	public ResponseEntity<?> getAllAddressstatus() {
		List<String> list= new ArrayList<>();
		for(Addressstatus data:Addressstatus.values()) {
			list.add(data.getAddressstatus());
		}
		return ResponseEntity.ok(list);
	}

}
