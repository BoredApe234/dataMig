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

import com.mps.think.setup.serviceImpl.LableGroupServiceImp;
import com.mps.think.setup.vo.LableGroupVO;

@RestController
@CrossOrigin
public class LableGroupController {

	@Autowired
	LableGroupServiceImp lableGroupServiceImp;

	@GetMapping("/findAllLableGroup")
	public ResponseEntity<?> findAllLableGroup() {
		return ResponseEntity.ok(lableGroupServiceImp.findAllLableGroupt());
	}

	@PostMapping("/saveLableGroup")
	public ResponseEntity<?> saveLableGroup(@RequestBody LableGroupVO lableGroupVO) {
		return ResponseEntity.ok(lableGroupServiceImp.saveLableGroup(lableGroupVO));
	}

	@PostMapping("/updateLableGroup")
	public ResponseEntity<?> updateLableGroup(@RequestBody LableGroupVO lableGroupVO) {
		return ResponseEntity.ok(lableGroupServiceImp.updateLableGroup(lableGroupVO));
	}

	@PostMapping("/findbyLableGroupId")
	public ResponseEntity<?> findbyLableFormatId(@RequestBody Integer lableGroupFormatId) {
		return ResponseEntity.ok(lableGroupServiceImp.findbyLableGroup(lableGroupFormatId));
	}
	
	@DeleteMapping("/deleteByLableGroupId")
	public ResponseEntity<?> deleteByLableGroupId(@RequestBody Integer lableGroupId) {
		return ResponseEntity.ok(lableGroupServiceImp.deleteByLableGroupId(lableGroupId));
	}
	
	@PostMapping("getAllLableGroupForPublisher")
	public ResponseEntity<?> getAllLableGroupForPublisher(@RequestBody Integer lableGroupId) {
		return ResponseEntity.ok(lableGroupServiceImp.findAllLableGroupByPubId(lableGroupId));
	}

}
