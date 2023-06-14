package com.mps.think.setup.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.AddressStatus;
import com.mps.think.setup.repo.AddressStatusRepo;
import com.mps.think.setup.service.AddressStatusService;
import com.mps.think.setup.vo.AddressStatusVO;

@Service
public class AddressStatusServiceImpl implements AddressStatusService{
	
	@Autowired
	private AddressStatusRepo addressStatusRepo;
	
	@Autowired
	private ObjectMapper mapper;

	@Override
	public List<AddressStatus> getAllAddressStatus() {
		return addressStatusRepo.findAll();
	}

	@Override
	public AddressStatus saveAddressStatus(AddressStatusVO addressStatus) {
		if(addressStatus.getDefaultstatus() != null && addressStatus.getDefaultstatus()) {
			makeOtherAddressStatusFalse(addressStatus.getPubId().getId());			
		}
		return addressStatusRepo.saveAndFlush(mapper.convertValue(addressStatus, AddressStatus.class));
	}

	@Override
	public AddressStatus updateAddressStatus(AddressStatusVO addressStatus) {
		if(addressStatus.getDefaultstatus() != null && addressStatus.getDefaultstatus()) {
			makeOtherAddressStatusFalse(addressStatus.getPubId().getId());			
		}
		return addressStatusRepo.saveAndFlush(mapper.convertValue(addressStatus, AddressStatus.class));
	}
	
	private void makeOtherAddressStatusFalse(Integer pubId) {
		List<AddressStatus> addressStatus = addressStatusRepo.findByPubIdId(pubId);
		addressStatus.stream().filter(cc -> cc.getDefaultstatus() == null || cc.getDefaultstatus()).forEach(c -> {
			c.setDefaultstatus(false);
		});
		addressStatusRepo.saveAllAndFlush(addressStatus);
	}

	@Override
	public AddressStatus findbyAddressStatusId(Integer id) {
		return addressStatusRepo.findById(id).get();
	}

	@Override
	public AddressStatus deleteByAddressStatusId(Integer id) {
		AddressStatus delete = findbyAddressStatusId(id);
		addressStatusRepo.delete(delete);
		return delete;
	}

	@Override
	public List<AddressStatus> findAllAddressStatusByPubId(Integer pubId) {
		return addressStatusRepo.findByPubIdId(pubId);
	}

}
