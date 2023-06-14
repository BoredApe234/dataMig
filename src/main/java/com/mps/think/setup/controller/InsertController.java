package com.mps.think.setup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mps.think.setup.service.InsertService;
import com.mps.think.setup.vo.InsertsVO;


@RestController
@CrossOrigin
public class InsertController {
	
	@Autowired
	private InsertService insertService;
	
	@GetMapping("/getAllInsert")
	public ResponseEntity<?> getAllInserts() {
		return ResponseEntity.ok(insertService.getAllInserts());
	}
	
	@PostMapping("/saveInsert")
	public ResponseEntity<?> saveInserts(@RequestBody InsertsVO id) {
		return ResponseEntity.ok(insertService.saveInserts(id));
	}
	
	@PostMapping("/updateInsert")
	public ResponseEntity<?> updateInserts(@RequestBody InsertsVO id) {
		return ResponseEntity.ok(insertService.updateInserts(id));	
		}
	
	@PostMapping("/findbyInsertId")
	public ResponseEntity<?> findbySplitsId(@RequestBody Integer id) {
		return ResponseEntity.ok(insertService.findbyInsertsId(id));
	}
	
	@DeleteMapping("/deletebyInsertId")
	public ResponseEntity<?> deleteBySplitsId(@RequestBody Integer id) {
		return ResponseEntity.ok(insertService.deleteByInsertsId(id));
	}

}
