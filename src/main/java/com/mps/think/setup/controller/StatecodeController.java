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
import com.mps.think.setup.service.StatecodeService;
import com.mps.think.setup.vo.StatecodeVO;
import com.mps.think.setup.vo.EnumModelVO.StateCode;

@RestController
@CrossOrigin
public class StatecodeController {
	
	@Autowired
	StatecodeService statecodeService;
	
	@GetMapping("/getAllStatecode")
	public ResponseEntity<?> getAllStatecode() {
		return ResponseEntity.ok(statecodeService.getAllStatecode());
	}
	
	@PostMapping("/saveStatecode")
	public ResponseEntity<?> saveStatecode(@RequestBody StatecodeVO id) {
		return ResponseEntity.ok(statecodeService.saveStatecode(id));
	}
	
	@PostMapping("/updateStatecode")
	public ResponseEntity<?> updatejurisdictions(@RequestBody StatecodeVO id) {
		return ResponseEntity.ok(statecodeService.updateStatecode(id));
	}
	
	@PostMapping("/findbyStatecodeId")
	public ResponseEntity<?> findbyId(@RequestBody Integer id) {
		return ResponseEntity.ok(statecodeService.findbyStatecodeId(id));
	}
	
	@DeleteMapping("/deleteByStatecodeId")
	public ResponseEntity<?> deleteByStatecodeId(@RequestBody Integer id) {
		return ResponseEntity.ok(statecodeService.deleteByStatecodeId(id));
	}
	
	@GetMapping("/findAllCountry")
	public ResponseEntity<?> getAllStateCode() {
		List<String> list= new ArrayList<>();
		for(StateCode data:StateCode.values()) {
			list.add(data.getStateCode());
		}
		return ResponseEntity.ok(list);
	}
	
	@PostMapping("/findstatebycountry")
	public ResponseEntity<?> findbyPubId(@RequestBody String country) {
		return ResponseEntity.ok(statecodeService.findAllStatecodeForCountry(country));
	}

}
