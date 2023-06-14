package com.mps.think.setup.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.mps.think.setup.model.AddressStatus;
import com.mps.think.setup.model.CustomerCategory;
import com.mps.think.setup.vo.AddressStatusVO;

@Service
public interface AddressStatusService {
	
	public List<AddressStatus> getAllAddressStatus();
	
	public AddressStatus saveAddressStatus(AddressStatusVO addressStatus);

	public AddressStatus updateAddressStatus(AddressStatusVO addressStatus);

	public AddressStatus findbyAddressStatusId(Integer id);
	
	public AddressStatus deleteByAddressStatusId(Integer id);
	
	public List<AddressStatus> findAllAddressStatusByPubId(Integer pubId);

}
