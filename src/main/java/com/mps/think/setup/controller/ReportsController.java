package com.mps.think.setup.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.setup.service.ReportsService;

@RestController
@CrossOrigin
public class ReportsController {
	
	@Autowired
	private ReportsService reportsService;

	@GetMapping("/getAllOrderReports")
	public ResponseEntity<?> getAllOrderReports(@RequestParam(required = false) String orderStatus, @RequestParam(required = false) String ordersFrom,
			@RequestParam(required = false) String ordersTill, @RequestParam(required = false) Integer customerId, @RequestParam(required = false) String customerName, 
			@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer size) throws ParseException {
		Date ordersFromDate = (ordersFrom == null || ordersFrom.isEmpty()) ? null : new SimpleDateFormat("dd/MM/yyyy").parse(ordersFrom);
		Date ordersTillDate = (ordersTill == null || ordersTill.isEmpty()) ? null : new SimpleDateFormat("dd/MM/yyyy").parse(ordersTill);
		return ResponseEntity.ok(reportsService.getAllOrderReports(orderStatus, ordersFromDate, ordersTillDate, customerId, customerName, PageRequest.of(page, size)));
	}
	
}
