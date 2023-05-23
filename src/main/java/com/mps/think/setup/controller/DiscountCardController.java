package com.mps.think.setup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.setup.model.DiscountCardKeyInfo;
import com.mps.think.setup.model.EffectiveDatesForDiscount;
import com.mps.think.setup.service.DiscountCardKeyInfoService;
import com.mps.think.setup.service.EffectiveDatesForDiscountService;
import com.mps.think.setup.vo.DiscountCardKeyInfoVO;
import com.mps.think.setup.vo.EffectiveDatesForDiscountVO;

@RestController
@CrossOrigin
public class DiscountCardController {

	@Autowired
	private DiscountCardKeyInfoService discountCardKeyInfoService;
	
	@Autowired
	private EffectiveDatesForDiscountService effectiveDatesForDiscountService;
	
	@PostMapping("/saveDiscountCardKeyInfo")
	public ResponseEntity<?> saveDiscountCardKeyInfo(@RequestBody DiscountCardKeyInfoVO discountCardKeyInfo) {
		return ResponseEntity.ok(discountCardKeyInfoService.saveDiscountCard(discountCardKeyInfo));
	}
	
	@PutMapping("/updateDiscountCardKeyInfo")
	public ResponseEntity<?> updateDiscountCardKeyInfo(@RequestBody DiscountCardKeyInfo discountCardKeyInfo) {
		return ResponseEntity.ok(discountCardKeyInfoService.updateDiscountCard(discountCardKeyInfo));
	}
	
	@PostMapping("/saveEffectiveDateForDiscount")
	public ResponseEntity<?> saveEffectiveDateForDiscount(@RequestBody EffectiveDatesForDiscountVO effectiveDateForDiscount) {
		return ResponseEntity.ok(effectiveDatesForDiscountService.saveEffectiveDateForDiscount(effectiveDateForDiscount));
	}
	
	@PutMapping("/updateEffectiveDateForDiscount")
	public ResponseEntity<?> updateEffectiveDateForDiscount(@RequestBody EffectiveDatesForDiscount effectiveDateForDiscount) {
		return ResponseEntity.ok(effectiveDatesForDiscountService.updateEffectiveDatesForDiscount(effectiveDateForDiscount));
	}
	
	@DeleteMapping("deleteDiscountCard")
	public ResponseEntity<?> deleteDiscountCard(@RequestBody Integer id) {
		return ResponseEntity.ok(discountCardKeyInfoService.deleteDiscountCardById(id));
	}
	
	@GetMapping("/getAllDiscountCardInfoForOrderClass/{ocId}")
	public ResponseEntity<?> getAllDiscountCardInfoForParent(@PathVariable("ocId") Integer ocId) {
		return ResponseEntity.ok(discountCardKeyInfoService.getDiscountCardKeyInfosForOrderClass(ocId));
	}
	
	@DeleteMapping("/deleteEffectiveDatesForDiscountById")
	public ResponseEntity<?> deleteEffectiveDatesForDiscountById(@RequestBody Integer id) {
		return ResponseEntity.ok(effectiveDatesForDiscountService.deleteEffectiveDatesForDiscountById(id));
	}
	
	@GetMapping("/getEffectiveDatesForDiscountCard/{discountCardId}")
	public ResponseEntity<?> getEffectiveDatesForDiscountCard(@PathVariable("discountCardId") Integer discountCardId) {
		return ResponseEntity.ok(effectiveDatesForDiscountService.getEffectiveDatesForDiscountCard(discountCardId));
	}
	
	@GetMapping("/getAllDiscountCards")
	public ResponseEntity<?> getAllDiscountCards() {
		return ResponseEntity.ok(discountCardKeyInfoService.getAllDiscountCards());
	}
	
	@GetMapping("/getDiscountCardById/{id}")
	public ResponseEntity<?> getDiscountCardById(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(discountCardKeyInfoService.getDiscountCardKeyInfoById(id));
	}
	
	@GetMapping("/getAllEffectiveDates")
	public ResponseEntity<?> getAllEffectiveDates() {
		return ResponseEntity.ok(effectiveDatesForDiscountService.getAllEffectiveDates());
	}
	
	@GetMapping("/getEffectiveDateById/{id}")
	public ResponseEntity<?> getEffectiveDateById(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(effectiveDatesForDiscountService.getEffectiveDateById(id));
	}
	
	@PostMapping("getAllDiscountCardForPublisher")
	public ResponseEntity<?> findAllDiscountCardKeyInfoByPublisherId(@RequestBody Integer PubId) {
		return ResponseEntity.ok(discountCardKeyInfoService.findAllDiscountCardKeyInfoByPublisherId(PubId));
	}
	
}
