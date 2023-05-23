package com.mps.think.setup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.ProfitCenter;
@Repository
public interface ProfitCenterRepo extends JpaRepository<ProfitCenter, Integer> {

	List<ProfitCenter> findByPubIdId(Integer pubId);
}
