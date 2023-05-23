package com.mps.think.setup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mps.think.setup.service.ProcessTypeService;
import com.mps.think.setup.vo.ProcessTypeVO;

@RestController
@CrossOrigin
public class ProcessTypeController {
	
	@Autowired
	ProcessTypeService processTypeService;
	
	@GetMapping("/getAllprocessType")
	public ResponseEntity<?> getAllProcessType() {
		return ResponseEntity.ok(processTypeService.getAllProcessType());
	}
	
	@PostMapping("/saveProcessType")
	public ResponseEntity<?> saveProcessType(@RequestBody ProcessTypeVO id) {
		return ResponseEntity.ok(processTypeService.saveProcessType(id));
	}
	
	@PostMapping("/updateProcessType")
	public ResponseEntity<?> updateProcessOutput(@RequestBody ProcessTypeVO id) {
		return ResponseEntity.ok(processTypeService.updateProcessType(id));
	}
	
	@PostMapping("/findbyProcessTypeId")
	public ResponseEntity<?> findbyProcessOutputId(@RequestBody Integer id) {
		return ResponseEntity.ok(processTypeService.findbyProcessTypeId(id));
	}
	
	@DeleteMapping("/deletebyProcessTypeId")
	public ResponseEntity<?> deleteByProcessId(@RequestBody Integer id) {
		return ResponseEntity.ok(processTypeService.deleteByProcessTypeId(id));
	}

}
