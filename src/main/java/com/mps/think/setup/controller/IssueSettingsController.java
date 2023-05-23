package com.mps.think.setup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.setup.service.IssueSettingsService;
import com.mps.think.setup.vo.IssueGenerationVo;
import com.mps.think.setup.vo.IssueSettingsVO;

@RestController
@CrossOrigin
public class IssueSettingsController {

	@Autowired
	IssueSettingsService issueSettingsService;
	
	@GetMapping("/findAllIssueSetting")
	public ResponseEntity<?> findAllIssueSetting() {
		return ResponseEntity.ok(issueSettingsService.findAllIssueSetting());
	}

	@PostMapping("/saveIssueSetting")
	public ResponseEntity<?> saveIssueSetting(@RequestBody IssueSettingsVO issueSettingsVO) {
		return ResponseEntity.ok(issueSettingsService.saveIssueSetting(issueSettingsVO));
	}

	@PostMapping("/updateIssueSetting")
	public ResponseEntity<?> updateIssueSetting(@RequestBody IssueSettingsVO IssueSettingsVO) {
		return ResponseEntity.ok(issueSettingsService.updateIssueSetting(IssueSettingsVO));
	}

	@PostMapping("/findbyIssueSettingId")
	public ResponseEntity<?> findbyIssueSettingId(@RequestBody Integer IssueSettingId) {
		return ResponseEntity.ok(issueSettingsService.findbyIssueSettingId(IssueSettingId));
	}
	
	@PostMapping("/getAllIssueSettingsForPublisher")
	public ResponseEntity<?> getAllIssueSettingsForPublisher(@RequestBody Integer pubId) {
		return ResponseEntity.ok(issueSettingsService.getAllIssueSettingsForPublisher(pubId));
	}
}
