package com.mps.think.setup.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.RenewalCard;
import com.mps.think.setup.model.SourceCode;
import com.mps.think.setup.repo.RenewalCardRepo;
import com.mps.think.setup.service.RenewalCardService;
import com.mps.think.setup.vo.RenewalCardVO;

@Service
public class RenewalCardServiceImpl implements RenewalCardService {

	@Autowired
	RenewalCardRepo renewalCardRepo;

	@Override
	public List<RenewalCard> findAllRenewalCard() {
		return renewalCardRepo.findAll();
	}

	@Override
	public RenewalCardVO saveRenewalCard(RenewalCardVO renewalCardVO) {
		ObjectMapper mapper = new ObjectMapper();
		RenewalCard rcard = mapper.convertValue(renewalCardVO, RenewalCard.class);
		if(renewalCardVO.getDiscountClassId().getId()==0){
			rcard.setDiscountClassId(null);;
		}
		if(renewalCardVO.getSubscriptionDefId().getId()==0){
			rcard.setSubscriptionDefId(null);
		}
		RenewalCard data= renewalCardRepo.saveAndFlush(rcard);
		renewalCardVO.setRenewalCardId(data.getRenewalCardId());
		return renewalCardVO;
	}

	@Override
	public RenewalCardVO updateRenewalCard(RenewalCardVO renewalCardVO) {
		ObjectMapper mapper = new ObjectMapper();
		RenewalCard rcard = mapper.convertValue(renewalCardVO, RenewalCard.class);
		if(renewalCardVO.getDiscountClassId().getId()==0){
			rcard.setDiscountClassId(null);;
		}
		if(renewalCardVO.getSubscriptionDefId().getId()==0){
			rcard.setSubscriptionDefId(null);
		}
		renewalCardRepo.saveAndFlush(rcard);
		return renewalCardVO;
	}
		

	@Override
	public RenewalCard findbyRenewalCardId(Integer renewalCardId) {
		Optional<RenewalCard> vo=renewalCardRepo.findById(renewalCardId);
		return vo.get() ;
	}

	@Override
	public RenewalCard deleteRenewalCard(Integer renewalCardId) {
		RenewalCard id= renewalCardRepo.findById(renewalCardId).get();
		renewalCardRepo.deleteById(renewalCardId);
		return id;
	}

	@Override
	public List<RenewalCard> getAllRenewalCardForPublisher(Integer pubId) {
		return renewalCardRepo.findByPubIdId(pubId);
	}

}
