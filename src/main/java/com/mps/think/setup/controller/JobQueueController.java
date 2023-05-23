package com.mps.think.setup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mps.think.setup.service.JobQueueService;
import com.mps.think.setup.vo.JobQueueVO;

@RestController
@CrossOrigin
public class JobQueueController {
	
	@Autowired
	JobQueueService jobQueueService;
	
	@GetMapping("/getAlljobQueue")
	public ResponseEntity<?> getAllJobQueue() {
		return ResponseEntity.ok(jobQueueService.findAllJobQueue());
	}
	
	@PostMapping("/saveJobQueue")
	public ResponseEntity<?> saveJobQueue(@RequestBody JobQueueVO id) {
		return ResponseEntity.ok(jobQueueService.saveJobQueue(id));
	}
	
	@PostMapping("/updateJobQueue")
	public ResponseEntity<?> updateJobQueue(@RequestBody JobQueueVO id) {
		return ResponseEntity.ok(jobQueueService.updateJobQueue(id));
	}
	
	@PostMapping("/findbyJobQueueId")
	public ResponseEntity<?> findbyJobQueueId(@RequestBody Integer id) {
		return ResponseEntity.ok(jobQueueService.findbyId(id));
	}
	
	@DeleteMapping("/deletebyJobQueueId")
	public ResponseEntity<?> deletebyJobQueueId(@RequestBody Integer id) {
		return ResponseEntity.ok(jobQueueService.deleteById(id));
	}

}
