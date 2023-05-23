package com.mps.think.setup.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.setup.serviceImpl.SourceFormatServiceImpl;
import com.mps.think.setup.utils.AppConstants.codeGen;
import com.mps.think.setup.vo.SourceFormatVo;

@RestController
@CrossOrigin
public class SourceFormatController {
	@Autowired
	SourceFormatServiceImpl SourceformatServiceImpl;

	@RequestMapping(value = "/findAllSourceFormat", method = RequestMethod.GET)
	public ResponseEntity<?> findAllSourceFormat() {

		return ResponseEntity.ok(SourceformatServiceImpl.findAllSourceFormat());
	}

	@RequestMapping(value = "/saveSourceFormat", method = RequestMethod.POST)
	public ResponseEntity<?> saveSourceFormat(@Valid @RequestBody SourceFormatVo sourceFormatVo) {

		return ResponseEntity.ok(SourceformatServiceImpl.saveSourceFormat(sourceFormatVo));
	}

	@PostMapping("/updateSourceFormat")
	public ResponseEntity<?> updateSourceFormat(@RequestBody SourceFormatVo sourceFormatVo) {
		return ResponseEntity.ok(SourceformatServiceImpl.updateSourceFormat(sourceFormatVo));
	}

	@RequestMapping(value = "/findbySourceFormatId", method = RequestMethod.POST)
	public ResponseEntity<?> findbySourceFormatId(@Valid @RequestBody Integer sourceFormatId) {
		return ResponseEntity.ok(SourceformatServiceImpl.findbySourceFormatId(sourceFormatId));
	}
	
	@RequestMapping(value = "/getAllSourceFormatForPublisher", method = RequestMethod.POST)
	public ResponseEntity<?> getAllSourceFormatForPublisher(@Valid @RequestBody Integer pubId) {
		return ResponseEntity.ok(SourceformatServiceImpl.getAllSourceFormatForPublisher(pubId));
	}
	@GetMapping("/getAllCodeGen")
	public ResponseEntity<?> getAllCodeGen() {
		List<String> list= new ArrayList<>();
		list.add(codeGen.None.displayName());
		list.add(codeGen.Promotions.displayName());
		list.add(codeGen.Renewals.displayName());
		return ResponseEntity.ok(list);
	}
	
	@DeleteMapping("/deleteBySourceFormatId")
	public ResponseEntity<?> deleteBySourceFormatId(@RequestBody Integer id) {
		return ResponseEntity.ok(SourceformatServiceImpl.deleteBySourceFormatId(id));
	}
}
