package com.mps.think.setup.service;

import java.util.List;
import java.util.Optional;

import com.mps.think.setup.model.MailTemplate;
import com.mps.think.setup.model.MakePayment;
import com.mps.think.setup.vo.MailTemplateVO;
import com.mps.think.setup.vo.MakePaymentVO;

public interface MakePaymentService {
	
	public List<MakePayment> findAllMakePaymentByPubId(Integer pubId);
	
	public MakePayment saveMakePayment(MakePaymentVO makePaymentVO);
	
	public MakePayment updateMakePayment(MakePaymentVO makePaymentVO);
	
	public Optional<MakePayment> findByMakePaymentId(Integer id);
	
	public MailTemplateVO sendPaymentLink(MailTemplateVO mailTemplateVO);

}
