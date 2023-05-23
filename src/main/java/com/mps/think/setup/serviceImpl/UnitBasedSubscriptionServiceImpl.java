package com.mps.think.setup.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import com.mps.think.setup.model.Publisher;
import com.mps.think.setup.model.UnitBasedSubscription;
import com.mps.think.setup.repo.UnitBasedSubscriptionRepo;
import com.mps.think.setup.service.UnitBasedSubscriptionService;
import com.mps.think.setup.vo.UnitBasedSubscriptionVO;

@Service
public class UnitBasedSubscriptionServiceImpl implements UnitBasedSubscriptionService{

	@Autowired
    private UnitBasedSubscriptionRepo unitBasedSubscriptionRepo;

	@Override
	public List<UnitBasedSubscription> findAllUnitBasedSubscription() {
		return unitBasedSubscriptionRepo.findAll();
	}

	@Override
	public UnitBasedSubscriptionVO saveUnitBasedSubscription(UnitBasedSubscriptionVO UnitBasedSubscription) {
		UnitBasedSubscription data=new UnitBasedSubscription();
		data.setLabel(UnitBasedSubscription.getLabel());
		data.setDiscription(UnitBasedSubscription.getDiscription());
		Publisher publisher=new Publisher();
		publisher.setId(UnitBasedSubscription.getPubId().getId());
		data.setPubId(publisher);
		unitBasedSubscriptionRepo.saveAndFlush(data);
		return UnitBasedSubscription;
	}

	@Override
	public UnitBasedSubscriptionVO updateUnitBasedSubscription(UnitBasedSubscriptionVO unitBasedSubscription) {
		UnitBasedSubscription data=new UnitBasedSubscription();
		data.setUbsid(unitBasedSubscription.getUbsid());
		Publisher publisher=new Publisher();
		publisher.setId(unitBasedSubscription.getPubId().getId());
		data.setPubId(publisher);
		data.setLabel(unitBasedSubscription.getLabel());
		data.setDiscription(unitBasedSubscription.getDiscription());
		unitBasedSubscriptionRepo.saveAndFlush(data);
		return unitBasedSubscription;
	}
	
	@Override
	public UnitBasedSubscription findbyUnitBasedSubscriptionId(Integer UnitBasedSubscriptionId) {
		Optional<UnitBasedSubscription> cr = unitBasedSubscriptionRepo.findById(UnitBasedSubscriptionId);
		if(!cr.isPresent()) {
			throw new NotFoundException("Unit Based Subscription Id : "+ UnitBasedSubscriptionId +" does not exist!");
		}
		return cr.get();
	}

	@Override
	public UnitBasedSubscription deleteByUnitBasedSubscriptionId(Integer ubsid) {
		UnitBasedSubscription delete = findbyUnitBasedSubscriptionId(ubsid);
		unitBasedSubscriptionRepo.delete(delete);
		return delete;
	}

	@Override
	public List<UnitBasedSubscription> findAllUnitBasedSubscriptionByPubId(Integer publisherId) {
		// TODO Auto-generated method stub
		return unitBasedSubscriptionRepo.findByPubIdId(publisherId);
	}

	
	

}
