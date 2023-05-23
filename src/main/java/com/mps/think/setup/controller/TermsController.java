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

import com.mps.think.setup.service.TermsService;
import com.mps.think.setup.vo.EnumModelVO.InstallmentTerm;
import com.mps.think.setup.vo.EnumModelVO.StartType;
import com.mps.think.setup.vo.TermsVO;


@RestController
@CrossOrigin
public class TermsController {
	
	@Autowired
	TermsService termsService;
	
	@GetMapping("/getAllTerms")
	public ResponseEntity<?> getAllTerms() {
		return ResponseEntity.ok(termsService.findAllTerms());
	}
	
	@PostMapping("/saveTerms")
	public ResponseEntity<?> saveterms(@RequestBody TermsVO termsId) {
		return ResponseEntity.ok(termsService.saveTerms(termsId));
	}
	
	@PostMapping("/updateTerms")
	public ResponseEntity<?> updateterms(@RequestBody TermsVO termsId) {
		return ResponseEntity.ok(termsService.updateTerms(termsId));
	}
	
	@PostMapping("/findbyTermsId")
	public ResponseEntity<?> findbyTermsId(@RequestBody Integer termsId) {
		return ResponseEntity.ok(termsService.findbytermsId(termsId));
	}
	
	@GetMapping("/findAllInstallmentTerm")
		public ResponseEntity<?> getAllInstallmentTerm() {
			List<String> list= new ArrayList<>();
			for(InstallmentTerm data:InstallmentTerm.values()) {
				list.add(data.getDisplayName());
			}
			return ResponseEntity.ok(list);
	}
	
	@GetMapping("/findAllStartType")
	public ResponseEntity<?> getAllStartType() {
		List<String> list= new ArrayList<>();
		for(StartType data:StartType.values()) {
			list.add(data.getDisplayName());
		}
		return ResponseEntity.ok(list);
	}
	
	@DeleteMapping("/deleteByTermsId")
	public ResponseEntity<?> deleteBytermsId(@RequestBody Integer termsId) {
		return ResponseEntity.ok(termsService.deleteBytermsId(termsId));
	}
	
	@PostMapping("/getAllTermsForPublisher")
	public ResponseEntity<?> findAllTermsForPublisher(@RequestBody Integer pubId) {
		return ResponseEntity.ok(termsService.findAllTermsForPublisher(pubId));
	}

}
