package com.mps.think.setup.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mps.think.setup.service.RepeatingService;
import com.mps.think.setup.vo.RepeatingVO;
import com.mps.think.setup.vo.EnumModelVO.Interval;


@RestController
@CrossOrigin
public class RepeatingController {
	
	@Autowired
	private RepeatingService repeatingService;
	
	@GetMapping("/getAllRepeating")
	public ResponseEntity<?> getAllRepeating() {
		return ResponseEntity.ok(repeatingService.getAllRepeating());	}
	
	@PostMapping("/saveRepeating")
	public ResponseEntity<?> saveInserts(@RequestBody RepeatingVO id) {
		return ResponseEntity.ok(repeatingService.saveRepeating(id));
	}
	
	@PostMapping("/updateRepeating")
	public ResponseEntity<?> updateRepeating(@RequestBody RepeatingVO id) {
		return ResponseEntity.ok(repeatingService.updateRepeating(id));	
		}
	
	@PostMapping("/findbyRepeatingId")
	public ResponseEntity<?> findbyRepeatingId(@RequestBody Integer id) {
		return ResponseEntity.ok(repeatingService.findbyRepeatingId(id));
	}
	
	@DeleteMapping("/deletebyRepeatingId")
	public ResponseEntity<?> deleteByRepeatingId(@RequestBody Integer id) {
		return ResponseEntity.ok(repeatingService.deleteByRepeatingId(id));
	}
	
	@GetMapping("/findAllInterval")
	public ResponseEntity<?> getAllInterval() {
		List<String> list= new ArrayList<>();
		for(Interval data:Interval.values()) {
			list.add(data.getInterval());
		}
		return ResponseEntity.ok(list);
	}

}
