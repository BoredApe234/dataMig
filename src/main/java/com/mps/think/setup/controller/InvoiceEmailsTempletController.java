package com.mps.think.setup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.setup.service.InvoiceEmailsTempletService;
import com.mps.think.setup.vo.InvoiceEmailsTempletVO;

@RestController
@CrossOrigin
public class InvoiceEmailsTempletController {
	
	@Autowired
	InvoiceEmailsTempletService invoiceEmailsTempletService;
	
	@PostMapping("/getAllInvoiceEmailsTamplet")
	public ResponseEntity<?> getAllInvoiceEmailsTamplet(@RequestBody Integer pubId){
		return ResponseEntity.ok(invoiceEmailsTempletService.getAllInvoiceEmailsTamplet(pubId));
	}
	
	@PostMapping("/saveInvoiceEmailsTamplet")
	public ResponseEntity<?> saveInvoiceEmailsTamplet(@RequestBody InvoiceEmailsTempletVO invoiceEmailsTempletVO){
		return ResponseEntity.ok(invoiceEmailsTempletService.saveInvoiceEmailsTamplet(invoiceEmailsTempletVO));
	}
	
	@PostMapping("/updateInvoiceEmailsTamplet")
	public ResponseEntity<?> updateInvoiceEmailsTamplet(@RequestBody InvoiceEmailsTempletVO invoiceEmailsTempletVO){
		return ResponseEntity.ok(invoiceEmailsTempletService.updateInvoiceEmailsTamplet(invoiceEmailsTempletVO));
	}
	
	@PostMapping("/findByInvoiceEmailsTampletId")
	public ResponseEntity<?> findByInvoiceEmailsTampletId(@RequestBody Integer id){
		return ResponseEntity.ok(invoiceEmailsTempletService.findByInvoiceEmailsTampletId(id));
	}
	
	@PostMapping("/defaultStatusInvoiceEmailsTamplet")
	public ResponseEntity<?> defaultStatusInvoiceEmailsTamplet(@RequestParam Integer id,@RequestParam Integer pubId){
		return ResponseEntity.ok(invoiceEmailsTempletService.defaultInvoiceEmailsTamplet(id, pubId));
	}

}
