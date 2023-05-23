package com.mps.think.setup.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.RateCardsRenewals;
import com.mps.think.setup.repo.RateCardsRenewalsRepo;
import com.mps.think.setup.service.RateCardsRenewalsService;
import com.mps.think.setup.vo.RateCardsRenewalsVO;

@Service
public class RateCardsRenewalsServiceImpl implements RateCardsRenewalsService{
	
	@Autowired
	private RateCardsRenewalsRepo rateCardsRenewalsRepo;

	@Override
	public List<RateCardsRenewals> getAllRateCardsRenewals() {
		return rateCardsRenewalsRepo.findAll();
	}

	@Override
	public RateCardsRenewalsVO saveRateCardsRenewals(RateCardsRenewalsVO rateCardsRenewals) {
		ObjectMapper mapper = new ObjectMapper();
		RateCardsRenewals newrateCardsRenewals= mapper.convertValue(rateCardsRenewals, RateCardsRenewals.class);
		rateCardsRenewalsRepo.saveAndFlush(newrateCardsRenewals);
		return rateCardsRenewals;
		
	}

	@Override
	public RateCardsRenewalsVO updateRateCardsRenewals(RateCardsRenewalsVO rateCardsRenewals) {
		ObjectMapper mapper = new ObjectMapper();
		RateCardsRenewals rateCardsRenewalsToUpdate = mapper.convertValue(rateCardsRenewals, RateCardsRenewals.class);
		rateCardsRenewalsRepo.saveAndFlush(rateCardsRenewalsToUpdate);
		return rateCardsRenewals;
		
	}

	@Override
	public RateCardsRenewals findbyRateCardsRenewalsId(Integer id) {
		 Optional<RateCardsRenewals> cr = rateCardsRenewalsRepo.findById(id);
			return cr.get();
	}

	@Override
	public RateCardsRenewals deleteByRateCardsRenewalsId(Integer id) {
		RateCardsRenewals delete = findbyRateCardsRenewalsId(id);
		rateCardsRenewalsRepo.delete(delete);
		return delete;
	}

	@Override
	public List<RateCardsRenewals> getAllRateCardsRenewalsByRcId(Integer renewalId) {
		List<RateCardsRenewals> output = new ArrayList<>();
		for (RateCardsRenewals rateCardsRenewals : rateCardsRenewalsRepo.findAll()) {
			if (rateCardsRenewals.getRenewalId().getRcId().equals(renewalId)) {
				output.add(rateCardsRenewals);
			}
		}
		return output;
	}

}
