package com.mps.think.setup.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.mps.think.setup.model.RateCards;
import com.mps.think.setup.model.RateCardsRenewals;
import com.mps.think.setup.repo.RateCardsRenewalsRepo;
import com.mps.think.setup.repo.RateCardsRepo;
import com.mps.think.setup.service.RateCardsService;
import com.mps.think.setup.vo.RateCardsVO;

@Service
public class RateCardsServiceImpl implements RateCardsService {
	
	@Autowired
	RateCardsRepo rateCardsRepo;
	
	@Autowired
	RateCardsRenewalsRepo renewalRepo;

	@Override
	public List<RateCards> findAllRateCards() {
		List<RateCards> rcList = rateCardsRepo.findAll();
		if (rcList.isEmpty()) {
			throw new NotFoundException("No RateCards present, please add RateCards!");
		}
		return rcList;
	}

	@Override
	public RateCardsVO saveRateCards(RateCardsVO rateCards) {
		ObjectMapper mapper = new ObjectMapper();
		RateCards newRateCards = mapper.convertValue(rateCards, RateCards.class);
		RateCards data=rateCardsRepo.saveAndFlush(newRateCards);
		rateCards.setRcId(data.getRcId());
		return rateCards;
	}

	@Override
	public RateCardsVO updateRateCards(RateCardsVO rateCards) {
		ObjectMapper mapper = new ObjectMapper();
		RateCards rateCardsToUpdate = mapper.convertValue(rateCards, RateCards.class);
		RateCards data=rateCardsRepo.saveAndFlush(rateCardsToUpdate);
		rateCards.setRcId(data.getRcId());
		return rateCards;
	}

	@Override
	public RateCards findbyrcId(Integer rcId) {
		 Optional<RateCards> rc = rateCardsRepo.findById(rcId);
			if(!rc.isPresent()) {
				throw new NotFoundException("RateCards Id : "+ rcId +" does not exist!");
			}
			return rc.get();
	}

	@Override
	public RateCards deleteByrcId(Integer rcId) {
		RateCards delete = findbyrcId(rcId);
		List<RateCardsRenewals> renewals = renewalRepo.findByRenewalIdRcId(rcId);
		renewals.forEach(r -> {
			renewalRepo.delete(r);
		});
		rateCardsRepo.delete(delete);
		return delete;
	}

	@Override
	public List<RateCards> findAllRateCardsByPublisherId(Integer pubId) {
		// TODO Auto-generated method stub
		return rateCardsRepo.findByOcIdPubIdId(pubId);
	}
}
