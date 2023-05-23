package com.mps.think.setup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.OrderClass;
@Repository
public interface OrderClassRepo extends JpaRepository<OrderClass, Integer>{
	
	@Query(value="SELECT * FROM oc where pub_id=:pubId",nativeQuery = true)
	public List<OrderClass> findAllOrderClassByPubId(@Param("pubId") Integer pubId);

}
