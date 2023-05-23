package com.mps.think.setup.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.PaymentType;

@Repository
public interface PaymentTypeRepo extends JpaRepository<PaymentType, Integer> {

	Page<PaymentType> findByPublisherIdOrderByIdDesc(Integer publisherId, Pageable page);
	
}
