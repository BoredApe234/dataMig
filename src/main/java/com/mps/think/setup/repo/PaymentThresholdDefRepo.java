package com.mps.think.setup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.PaymentThresholdDef;
@Repository
public interface PaymentThresholdDefRepo extends JpaRepository<PaymentThresholdDef, Integer>{

	List<PaymentThresholdDef> findByPublisherId(Integer pubId);
}
