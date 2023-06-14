package com.mps.think.setup.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.Address;
import com.mps.think.setup.model.Addresses;
import com.mps.think.setup.repo.AddressRepo;
import com.mps.think.setup.service.AddressessService;
import com.mps.think.setup.vo.AddressVO;

@Service
public class AddressServiceImpl implements AddressessService {

	@Autowired
	private AddressRepo addressRepo;

	@Autowired
	private ObjectMapper mapper;

	@Override
	public Address saveAddress(AddressVO address) {
		return addressRepo.saveAndFlush(mapper.convertValue(address, Address.class));
	}

	@Override
	public Address updateAddress(AddressVO address) {
		return addressRepo.saveAndFlush(mapper.convertValue(address, Address.class));
	}

	@Override
	public Address findbyAddressId(Integer id) {
		return addressRepo.findById(id).get();
	}

	@Override
	public Address deleteByAddressId(Integer id) {
		Address delete = findbyAddressId(id);
		addressRepo.delete(delete);
		return delete;
	}

	@Override
	public List<Address> findAllAddressForPublisher(Integer pubId) {
		return addressRepo.findByPubIdId(pubId);
	}

	@Override
	public List<Address> getAllAddress() {
		return addressRepo.findAll();
	}

	


}
