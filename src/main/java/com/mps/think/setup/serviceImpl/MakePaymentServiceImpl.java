package com.mps.think.setup.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.MailTemplate;
import com.mps.think.setup.model.MakePayment;
import com.mps.think.setup.repo.MailTemplateRepo;
import com.mps.think.setup.repo.MakePaymentRepo;
import com.mps.think.setup.service.MakePaymentService;
import com.mps.think.setup.utils.MailTemplateUtils;
import com.mps.think.setup.vo.MailTemplateVO;
import com.mps.think.setup.vo.MakePaymentVO;
@Service
public class MakePaymentServiceImpl implements MakePaymentService{
	
	@Autowired
	MakePaymentRepo makePaymentRepo;
	
	@Autowired
	MailTemplateRepo mailTemplateRepo;
	
	@Autowired
	MailTemplateUtils template;

	@Override
	public List<MakePayment> findAllMakePaymentByPubId(Integer pubId) {
		return makePaymentRepo.findByPublisherId(pubId);
	}

	@Override
	public MakePayment saveMakePayment(MakePaymentVO makePaymentVO) {
		ObjectMapper obj=new ObjectMapper();
		MakePayment makePayment=obj.convertValue(makePaymentVO, MakePayment.class);
		MakePayment data=makePaymentRepo.saveAndFlush(makePayment);
		return data;
	}

	@Override
	public MakePayment updateMakePayment(MakePaymentVO makePaymentVO) {
		ObjectMapper obj=new ObjectMapper();
		MakePayment makePayment=obj.convertValue(makePaymentVO, MakePayment.class);
		MakePayment data=makePaymentRepo.saveAndFlush(makePayment);
		return data;
	}

	@Override
	public Optional<MakePayment> findByMakePaymentId(Integer id) {
		return makePaymentRepo.findById(id);
	}

	@Override
	public MailTemplateVO sendPaymentLink(MailTemplateVO mailTemplateVO) {
		try {
			template.sendMailToCus(mailTemplateVO.getEmailFrom(), mailTemplateVO.getEmailTo(), mailTemplateVO.getEmailCC(), mailTemplateVO.getEmailSubject(), mailTemplateVO.getEmailContent());
			ObjectMapper obj=new ObjectMapper();
			mailTemplateRepo.saveAndFlush(obj.convertValue(mailTemplateVO, MailTemplate.class));
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return mailTemplateVO;
	}

	
}
