package com.mps.think.setup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.CreditStatus;
@Repository
public interface CreditStatusRepo extends JpaRepository<CreditStatus, Integer> {
	
	List<CreditStatus> findByPubIdId(Integer pubId);

}
