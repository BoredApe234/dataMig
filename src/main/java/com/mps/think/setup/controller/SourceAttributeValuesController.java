package com.mps.think.setup.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.setup.service.SourceAttributeValuesService;
import com.mps.think.setup.vo.SourceAttributeValuesVO;

@RestController
@CrossOrigin
public class SourceAttributeValuesController {
	
	@Autowired
	SourceAttributeValuesService sourceAttributeService;

	@GetMapping("/findAllSourceAttributeValues")
	public ResponseEntity<?> findAllSourceAttribute() {
		return ResponseEntity.ok(sourceAttributeService.findAllSourceAttribute());
	}

	@PostMapping("/saveSourceAttributeValue")
	public ResponseEntity<?> saveSourceAttribute(@Valid @RequestBody SourceAttributeValuesVO sourceAttributeVo) {
		return ResponseEntity.ok(sourceAttributeService.saveSourceAttribute(sourceAttributeVo));
	}

	@PutMapping("/updateSourceAttributeValue")
	public ResponseEntity<?> updateSourceAttribute(@RequestBody SourceAttributeValuesVO sourceAttributeVo) {
		return ResponseEntity.ok(sourceAttributeService.updateSourceAttribute(sourceAttributeVo));
	}

	@GetMapping("/findbySourceAttributeValueId/{sourceAttributeValueId}")
	public ResponseEntity<?> findbySourceAttributeId(@Valid @PathVariable("sourceAttributeValueId") Integer sourceAttributeValueId) throws Exception {
		return ResponseEntity.ok(sourceAttributeService.findbySourceAttributeId(sourceAttributeValueId));
	}
	
	@DeleteMapping("/deleteSourceAttributeValue")
	public ResponseEntity<?> deleteSourceAttribute(@RequestBody Integer id) throws Exception {
		return ResponseEntity.ok(sourceAttributeService.deleteSourceAttributeById(id));
	}
	
	@GetMapping("getAllSourceAttrValuesBySourceAttrId/{id}")
	public ResponseEntity<?> getAllSourceAttrValBySourceAttrId(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(sourceAttributeService.getAllSourceAttributeValuesByScId(id));
	}
	
	@PostMapping("getAllSourceAttributeValuesForPub")
	public ResponseEntity<?> getAllSourceAttributeValuesForPub(@RequestBody Integer pubid) {
		return ResponseEntity.ok(sourceAttributeService.getAllSourceAttributeValuesForPub(pubid));
	}
	
}
