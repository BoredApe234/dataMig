package com.mps.think.setup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.PaymentThreshold;
@Repository
public interface PaymentThresholdRepo extends JpaRepository<PaymentThreshold, Integer>{

	List<PaymentThreshold> findByPublisherId(@Param("pubId") Integer pubId);
	
	PaymentThreshold findByPaymentThresholdDefId(@Param("") Integer id);
}
