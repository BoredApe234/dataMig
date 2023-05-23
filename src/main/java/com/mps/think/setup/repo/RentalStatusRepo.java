package com.mps.think.setup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.RentalStatus;
@Repository
public interface RentalStatusRepo extends JpaRepository<RentalStatus, Integer> {
	
	public RentalStatus findByRentalStatusId(Integer rentalStatusid);
	
	public List<RentalStatus> findByPublisherId(Integer pubId);

}
