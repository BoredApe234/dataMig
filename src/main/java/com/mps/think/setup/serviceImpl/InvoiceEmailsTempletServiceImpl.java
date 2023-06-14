package com.mps.think.setup.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.InvoiceEmailsTemplet;
import com.mps.think.setup.repo.InvoiceEmailsTempletRepo;
import com.mps.think.setup.service.InvoiceEmailsTempletService;
import com.mps.think.setup.vo.InvoiceEmailsTempletVO;

@Service
public class InvoiceEmailsTempletServiceImpl implements InvoiceEmailsTempletService {
	@Autowired
	InvoiceEmailsTempletRepo invoiceEmailsTempletRepo;
	
	@Autowired
	ObjectMapper mapper;

	@Override
	public List<InvoiceEmailsTemplet> getAllInvoiceEmailsTamplet(Integer pubId) {
		return invoiceEmailsTempletRepo.findByPublisherId(pubId);
	}

	@Override
	public InvoiceEmailsTemplet saveInvoiceEmailsTamplet(InvoiceEmailsTempletVO invoiceEmailsTempletVO) {
		return invoiceEmailsTempletRepo.saveAndFlush(mapper.convertValue(invoiceEmailsTempletVO, InvoiceEmailsTemplet.class));
	}

	@Override
	public InvoiceEmailsTemplet updateInvoiceEmailsTamplet(InvoiceEmailsTempletVO invoiceEmailsTempletVO) {
		return invoiceEmailsTempletRepo.saveAndFlush(mapper.convertValue(invoiceEmailsTempletVO, InvoiceEmailsTemplet.class));
	}

	@Override
	public InvoiceEmailsTemplet findByInvoiceEmailsTampletId(Integer id) {
		return invoiceEmailsTempletRepo.findById(id).get();
	}

	@Override
	public List<InvoiceEmailsTemplet> defaultInvoiceEmailsTamplet(Integer id, Integer pubId) {
		List<InvoiceEmailsTemplet> list=new ArrayList<>();
		InvoiceEmailsTemplet emailtemp;
		List<InvoiceEmailsTemplet> invoicetemp = invoiceEmailsTempletRepo.findByPublisherId(pubId);
		for(InvoiceEmailsTemplet data:invoicetemp) {
			if(id==data.getId()) {
				data.setDefaultStatus(true);
			 emailtemp=invoiceEmailsTempletRepo.saveAndFlush(data);
			 list.add(emailtemp);
			}else {
				data.setDefaultStatus(false);
				emailtemp=invoiceEmailsTempletRepo.saveAndFlush(data);
				list.add(emailtemp);
			}
		}
		
		return list;
	}

	@Override
	public List<InvoiceEmailsTemplet> getAllInvoiceEmailsTemplet() {
		return invoiceEmailsTempletRepo.findAll();
	}

}
