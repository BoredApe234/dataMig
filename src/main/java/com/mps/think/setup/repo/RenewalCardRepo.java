package com.mps.think.setup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.RenewalCard;

@Repository
public interface RenewalCardRepo extends JpaRepository<RenewalCard, Integer> {

	List<RenewalCard> findByPubIdId(Integer pubId);

}
