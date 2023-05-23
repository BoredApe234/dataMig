package com.mps.think.setup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.MakePayment;
@Repository
public interface MakePaymentRepo extends JpaRepository<MakePayment, Integer>{
	
	List<MakePayment> findByPublisherId(Integer pubId);

}
