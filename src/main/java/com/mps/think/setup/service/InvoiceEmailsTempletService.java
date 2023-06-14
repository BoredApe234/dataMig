package com.mps.think.setup.service;

import java.util.List;

import com.mps.think.setup.model.InvoiceEmailsTemplet;
import com.mps.think.setup.vo.InvoiceEmailsTempletVO;

public interface InvoiceEmailsTempletService {
	
	public List<InvoiceEmailsTemplet>	getAllInvoiceEmailsTamplet(Integer pubId);
	
	public InvoiceEmailsTemplet	saveInvoiceEmailsTamplet(InvoiceEmailsTempletVO invoiceEmailsTempletVO);
	
	public InvoiceEmailsTemplet	updateInvoiceEmailsTamplet(InvoiceEmailsTempletVO invoiceEmailsTempletVO);
	
	public InvoiceEmailsTemplet	findByInvoiceEmailsTampletId(Integer id);
	
	public List<InvoiceEmailsTemplet>	defaultInvoiceEmailsTamplet(Integer id,Integer pubId);

	public List<InvoiceEmailsTemplet> getAllInvoiceEmailsTemplet();

}
