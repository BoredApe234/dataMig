package com.mps.think.setup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.setup.model.CurrencyExchange;
import com.mps.think.setup.service.CurrencyExchangeService;
import com.mps.think.setup.vo.CurrencyExchangeVO;

@RestController
@CrossOrigin
public class CurrencyExchangrController {
	
	@Autowired
	private CurrencyExchangeService currencyExchangeService;
	
	@GetMapping("/getAllCurrencyExchange")
	public ResponseEntity<?> getAllCurrencyExchange() {
		return ResponseEntity.ok(currencyExchangeService.getAllCurrencyExchange());
	}
	
	@PostMapping("/saveCurrencyExchange")
	public ResponseEntity<?> saveCurrencyExchange(@RequestBody CurrencyExchange id) {
		return ResponseEntity.ok(currencyExchangeService.saveCurrencyExchange(id));
	}
	
	@PostMapping("/updateCurrencyExchange")
	public ResponseEntity<?> updateCurrencyExchange(@RequestBody CurrencyExchange id) {
		return ResponseEntity.ok(currencyExchangeService.updateCurrencyExchange(id));	
		}
	
	@PostMapping("/findbyCurrencyExchangeId")
	public ResponseEntity<?> findbyId(@RequestBody Integer id) {
		return ResponseEntity.ok(currencyExchangeService.findbyId(id));
	}
	
	@DeleteMapping("/deletebyCurrencyExchangeId")
	public ResponseEntity<?> deleteByCurrencyExchangeId(@RequestBody Integer id) {
		return ResponseEntity.ok(currencyExchangeService.deleteByCurrencyExchangeId(id));
	}
	
	@PostMapping("/findCurrencyExchangebyPubId")
	public ResponseEntity<?> findAllCurrencyExchangeForPublisher(@RequestBody Integer pubId) {
		return ResponseEntity.ok(currencyExchangeService.findAllCurrencyExchangeForPublisher(pubId));
	}

}
