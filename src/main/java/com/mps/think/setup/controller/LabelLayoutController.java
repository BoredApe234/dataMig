package com.mps.think.setup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mps.think.setup.service.LabelLayoutService;
import com.mps.think.setup.vo.LabelLayoutVO;

@RestController
@CrossOrigin
public class LabelLayoutController {
	
	@Autowired
	LabelLayoutService labelLayoutService;
	
	@GetMapping("/getAllLabelLayout")
	public ResponseEntity<?> getAllLabelLayout() {
		return ResponseEntity.ok(labelLayoutService.getAllLabelLayout());
	}
	
	@PostMapping("/saveLabelLayout")
	public ResponseEntity<?> saveLabelLayout(@RequestBody LabelLayoutVO id) {
		return ResponseEntity.ok(labelLayoutService.saveLabelLayout(id));
	}
	
	@PostMapping("/updateLabelLayout")
	public ResponseEntity<?> updateLabelLayout(@RequestBody LabelLayoutVO id) {
		return ResponseEntity.ok(labelLayoutService.updateLabelLayout(id));
	}
	
	@PostMapping("/findbyLabelLayoutId")
	public ResponseEntity<?> findbyLabelLayoutId(@RequestBody Integer id) {
		return ResponseEntity.ok(labelLayoutService.findbyLabelLayoutId(id));
	}
	
	@DeleteMapping("/deleteByLabelLayoutId")
	public ResponseEntity<?> deleteByLabelLayoutId(@RequestBody Integer id) {
		return ResponseEntity.ok(labelLayoutService.deleteByLabelLayoutId(id));
	}

	@PostMapping("/getAllLabelLayoutForPublisher")
	public ResponseEntity<?> findAllLabelLayoutForPublisher(@RequestBody Integer pubId) {
		return ResponseEntity.ok(labelLayoutService.findAllLabelLayoutForPublisher(pubId));
	}

}
