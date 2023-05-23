package com.mps.think.setup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.SalesRepresentative;
@Repository
public interface SalesRepresentativeRepo extends JpaRepository<SalesRepresentative, Integer> {

	@Query(value="SELECT * FROM sales_representative where pub_id=:pubId",nativeQuery = true)
	public List<SalesRepresentative> findAllSalesRepresentativeByPubId(@Param("pubId") Integer pubId);
}
