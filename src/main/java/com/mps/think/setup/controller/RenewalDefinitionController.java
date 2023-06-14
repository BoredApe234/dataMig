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
import com.mps.think.setup.service.RenewalDefinitionService;
import com.mps.think.setup.vo.RenewalDefinitionVO;
import com.mps.think.setup.vo.EnumModelVO.Type;

@RestController
@CrossOrigin
public class RenewalDefinitionController {
	
	@Autowired
	private RenewalDefinitionService renewalDefinitionService;
	
	@GetMapping("/getAllRenewalDefinition")
	public ResponseEntity<?> getAllRenewalDefinition() {
		return ResponseEntity.ok(renewalDefinitionService.getAllRenewalDefinition());
	}
	
	@PostMapping("/saveRenewalDefinition")
	public ResponseEntity<?> saveRenewalDefinition(@RequestBody RenewalDefinitionVO id) {
		return ResponseEntity.ok(renewalDefinitionService.saveRenewalDefinition(id));
	}
	
	@PostMapping("/updateRenewalDefinition")
	public ResponseEntity<?> updateRenewalDefinition(@RequestBody RenewalDefinitionVO id) {
		return ResponseEntity.ok(renewalDefinitionService.updateRenewalDefinition(id));
	}
	
	@PostMapping("/findbyRenewalDefinitionId")
	public ResponseEntity<?> findbyRenewalDefinitionId(@RequestBody Integer id) {
		return ResponseEntity.ok(renewalDefinitionService.findbyRenewalDefinitionId(id));
	}
	
	@DeleteMapping("/deletebyRenewalDefinitionId")
	public ResponseEntity<?> deleteByRenewalDefinitionId(@RequestBody Integer id) {
		return ResponseEntity.ok(renewalDefinitionService.deleteByRenewalDefinitionId(id));
	}
	
	@GetMapping("/findAllType")
	public ResponseEntity<?> getAllIType() {
		List<String> list= new ArrayList<>();
		for(Type data:Type.values()) {
			list.add(data.getType());
		}
		return ResponseEntity.ok(list);
	}

}
