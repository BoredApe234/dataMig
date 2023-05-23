package com.mps.think.setup.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.SubscriptionDefKeyInfo;
import com.mps.think.setup.repo.SubscriptionDefKeyInfoRepo;
import com.mps.think.setup.service.SubscriptionDefKeyInfoService;
import com.mps.think.setup.vo.SubscriptionDefKeyInfoVO;

@Service
public class SubscriptionDefKeyInfoServiceImpl implements SubscriptionDefKeyInfoService {

	@Autowired
	private SubscriptionDefKeyInfoRepo subsRepo;
	
	@Override
	public SubscriptionDefKeyInfo saveSubscriptionDef(SubscriptionDefKeyInfoVO subsDef) {
		ObjectMapper mapper = new ObjectMapper();
		SubscriptionDefKeyInfo subscriptionDef = mapper.convertValue(subsDef, SubscriptionDefKeyInfo.class);
//		if (subsDef.getRenewalCard() == null || subsDef.getRenewalCard().getRenewalCardId() == 0) {
//			subscriptionDef.setRenewalCard(null);
//		}
		return subsRepo.saveAndFlush(subscriptionDef);
	}

	@Override
	public SubscriptionDefKeyInfo updateSubscriptionDef(SubscriptionDefKeyInfoVO subsDef) {
		ObjectMapper mapper = new ObjectMapper();
		SubscriptionDefKeyInfo subscriptionDef = mapper.convertValue(subsDef, SubscriptionDefKeyInfo.class);
//		if (subsDef.getRenewalCard() == null || subsDef.getRenewalCard().getRenewalCardId() == 0) {
//			subscriptionDef.setRenewalCard(null);
//		}
		return subsRepo.saveAndFlush(subscriptionDef);
	}

	@Override
	public SubscriptionDefKeyInfo deleteSubscriptionDef(Integer id) {
		Optional<SubscriptionDefKeyInfo> subs = subsRepo.findById(id);
		if (subs.isPresent()) { subsRepo.delete(subs.get()); return subs.get(); }
		return null;
	}

	@Override
	public List<SubscriptionDefKeyInfo> getSubscriptionDefByPublisherId(Integer id) {
		return subsRepo.findByPublisherId(id);
	}

	@Override
	public List<SubscriptionDefKeyInfo> getSubscriptionDefByOcId(Integer id) {
		return subsRepo.findByOrderClassOcId(id);
	}

	@Override
	public List<SubscriptionDefKeyInfo> getAllSubscriptionDef() {
		return subsRepo.findAll();
	}

	@Override
	public SubscriptionDefKeyInfo getSubscriptionDefById(Integer id) {
		Optional<SubscriptionDefKeyInfo> subsDef = subsRepo.findById(id);
		if(subsDef.isPresent()) {
			return subsDef.get();
		}
		return null;
	}

	@Override
	public List<SubscriptionDefKeyInfo> getAllSubscriptionsByOrderCode(Integer orderCodeId) {
		return subsRepo.findByOrderCodeId(orderCodeId);
	}


}
