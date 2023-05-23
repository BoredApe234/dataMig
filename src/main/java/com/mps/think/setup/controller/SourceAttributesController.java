package com.mps.think.setup.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.setup.service.SourceAttributesService;
import com.mps.think.setup.vo.SourceAttributesVO;

@RestController
@CrossOrigin
public class SourceAttributesController {
	
	@Autowired
	SourceAttributesService sourceAttributesService;

	@RequestMapping(value = "/findAllSourceAttributes", method = RequestMethod.GET)
	public ResponseEntity<?> findAllSourceAttributeValue() {
		return ResponseEntity.ok(sourceAttributesService.findAllSourceAttributes());
	}

	@RequestMapping(value = "/saveSourceAttribute", method = RequestMethod.POST)
	public ResponseEntity<?> saveSourceAttributeValue(
			@Valid @RequestBody SourceAttributesVO sourceAttributeValueVo) {
		return ResponseEntity.ok(sourceAttributesService.saveSourceAttribute(sourceAttributeValueVo));
	}

	@PutMapping("/updateSourceAttribute")
	public ResponseEntity<?> updateSourceAttributeValue(@RequestBody SourceAttributesVO sourceAttributeValueVo) {
		return ResponseEntity.ok(sourceAttributesService.updateSourceAttribute(sourceAttributeValueVo));
	}

	@RequestMapping(value = "/findbySourceAttributeId/{sourceAttributeId}", method = RequestMethod.GET)
	public ResponseEntity<?> findbySourceAttributeValueId(@Valid @PathVariable("sourceAttributeId") Integer sourceAttributeId) throws Exception {
		return ResponseEntity.ok(sourceAttributesService.findbySourceAttributeId(sourceAttributeId));
	}
	
	@RequestMapping(value = "/getAllSourceAttributeForPublisher", method = RequestMethod.POST)
	public ResponseEntity<?> getAllSourceAttributeForPublisher(@RequestBody Integer pubid)  {
		return ResponseEntity.ok(sourceAttributesService.getAllSourceAttributeForPublisher(pubid));
	}
	@DeleteMapping("/deleteSourceAttribute")
	public ResponseEntity<?> deleteSourceAttributeValue(@RequestBody Integer id) throws Exception {
		return ResponseEntity.ok(sourceAttributesService.deleteSourceAttribute(id));
	}
	
}
