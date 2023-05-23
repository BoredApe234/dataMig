package com.mps.think.setup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mps.think.setup.model.CancelReasons;

public interface CancelReasonsRepo extends JpaRepository<CancelReasons , Integer> {
	
	public CancelReasons findByCancelReasonsId(Integer CancelReasonsId);
	
	@Query(value="SELECT * FROM cancel_reasons where pub_id=:pubId",nativeQuery = true)
	public List<CancelReasons> findByPubId(@Param("pubId") Integer pubId);

}
