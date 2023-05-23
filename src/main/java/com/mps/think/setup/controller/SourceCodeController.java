package com.mps.think.setup.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.setup.service.SourceCodeService;

import com.mps.think.setup.vo.EnumModelVO.Source_code_type;
import com.mps.think.setup.vo.SourceCodeVO;

@RestController
@CrossOrigin
public class SourceCodeController {
	
	@Autowired
	SourceCodeService sourceCodeService;
	
	@GetMapping("/getAllSourceCode")
	public ResponseEntity<?> findAllSourceCode() {
		return ResponseEntity.ok(sourceCodeService.findAllSourceCode());
	}

	@PostMapping("/saveSourceCode")
	public ResponseEntity<?> saveSourceCode(@RequestBody SourceCodeVO sourceCodeId) {
		return ResponseEntity.ok(sourceCodeService.saveSourceCode(sourceCodeId));
	}
	
	@PostMapping("/updateSourceCode")
	public ResponseEntity<?> updateSourceCode(@RequestBody SourceCodeVO sourceCode) {
		return ResponseEntity.ok(sourceCodeService.updateSourceCode(sourceCode));
	}

	@PostMapping("/findbySourceCodeId")
	public ResponseEntity<?> findbysourceCodeId(@RequestBody Integer sourceCodeId) {
		return ResponseEntity.ok(sourceCodeService.findbySourceCodeId(sourceCodeId));
	}
	
	@DeleteMapping("/deleteSourceCodebyId")
	public ResponseEntity<?> deleteSourceCode(@RequestBody Integer sourceCodeId) {
		return ResponseEntity.ok(sourceCodeService.deleteSourceCodeById(sourceCodeId));
	}
	
	@GetMapping("/findAllsource_code_type")
	public ResponseEntity<?> getAllSource_code_type() {
		List<String> list= new ArrayList<>();
		for(Source_code_type data:Source_code_type.values()) {
			list.add(data.displayName());
		}
		return ResponseEntity.ok(list);
	}
	
	@PostMapping("getAllSourceCodeForPublisher")
	public ResponseEntity<?> findAllSourceCodeByPublisherId(@RequestBody Integer sourceCodeId) {
		return ResponseEntity.ok(sourceCodeService.findAllSourceCodeByPublisherId(sourceCodeId));
	}
	

}
