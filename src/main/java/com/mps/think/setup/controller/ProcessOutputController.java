package com.mps.think.setup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mps.think.setup.service.ProcessOutputService;
import com.mps.think.setup.vo.ProcessOutputVO;

@RestController
@CrossOrigin
public class ProcessOutputController {
	
	@Autowired
	ProcessOutputService processOutputService;
	
	@GetMapping("/getAllProcessOutput")
	public ResponseEntity<?> getAllProcessOutput() {
		return ResponseEntity.ok(processOutputService.getAllProcessOutput());
	}
	
	@PostMapping("/saveProcessOutput")
	public ResponseEntity<?> saveProcessOutput(@RequestBody ProcessOutputVO id) {
		return ResponseEntity.ok(processOutputService.saveProcessOutput(id));
	}
	
	@PostMapping("/updateProcessOutput")
	public ResponseEntity<?> updateProcessOutput(@RequestBody ProcessOutputVO id) {
		return ResponseEntity.ok(processOutputService.updateProcessOutput(id));
	}
	
	@PostMapping("/findbyProcessOutputId")
	public ResponseEntity<?> findbyProcessOutputId(@RequestBody Integer id) {
		return ResponseEntity.ok(processOutputService.findbyProcessOutputId(id));
	}
	
	@DeleteMapping("/deletebyProcessOutputId")
	public ResponseEntity<?> deleteByProcessId(@RequestBody Integer id) {
		return ResponseEntity.ok(processOutputService.deleteByProcessOutputId(id));
	}

}
