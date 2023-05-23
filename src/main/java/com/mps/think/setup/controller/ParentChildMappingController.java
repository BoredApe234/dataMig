package com.mps.think.setup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.setup.service.ParentChildMappingService;
import com.mps.think.setup.vo.ParentChildMappingVO;
@RestController
@CrossOrigin
public class ParentChildMappingController {
	
	@Autowired
	ParentChildMappingService childMappingService;

	@GetMapping("/getAllParentChild")
	public ResponseEntity<?> findAllParentChild() {
		return ResponseEntity.ok(childMappingService.findAllParentChild());
	}

	@PostMapping("/saveParentChild")
	public ResponseEntity<?> saveSourceCode(@RequestBody ParentChildMappingVO parentChildMappingVO) {
		return ResponseEntity.ok(childMappingService.saveAuxVParentChild(parentChildMappingVO));
	}
	
	@PostMapping("/updateAuxParentChild")
	public ResponseEntity<?> updateSourceCode(@RequestBody ParentChildMappingVO parentChildMappingVO) {
		return ResponseEntity.ok(childMappingService.updateAuxParentChild(parentChildMappingVO));
	}

	@PostMapping("/findbyParentChildMappingId")
	public ResponseEntity<?> findbysourceCodeId(@RequestBody Integer id) {
		return ResponseEntity.ok(childMappingService.findbyParentChildMappingId(id));
	}
	
	@PostMapping("/findAllParentChildByPublisherId")
	public ResponseEntity<?> findAllParentChildByPublisherId(@RequestBody Integer pubId) {
		return ResponseEntity.ok(childMappingService.findAllParentChildByPublisherId(pubId));
	}
}
