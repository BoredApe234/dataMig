package com.mps.think.setup.service;

import java.util.List;

import com.mps.think.setup.model.RentalStatus;
import com.mps.think.setup.vo.RentalStatusVO;

public interface RentalStatusService {

	public List<RentalStatus> findAllRentalStatus();

	public RentalStatusVO saveRentalStatus(RentalStatusVO rentalStatusVO);

	public RentalStatusVO updateRentalStatus(RentalStatusVO rentalStatusVO);

	public RentalStatus findbyRentalStatusId(Integer rentalStatusId);
	
	public List<RentalStatus> findRentalStatusByPubId(Integer pubId);
	
	public RentalStatus deleteByRentalStatusId(Integer rentalStatusId);

}
