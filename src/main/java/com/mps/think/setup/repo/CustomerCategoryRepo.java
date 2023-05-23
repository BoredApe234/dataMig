package com.mps.think.setup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.CustomerCategory;
@Repository
public interface CustomerCategoryRepo extends JpaRepository<CustomerCategory, Integer> {

	@Query(value="SELECT * FROM customer_category where pub_id=:pubId",nativeQuery = true)
	public List<CustomerCategory> findAllCustomerCategoryByPubId(@Param("pubId") Integer pub_id);
	@Query(value="SELECT * FROM customer_category where cust_Category=:CustCategory",nativeQuery = true)
	public CustomerCategory findByCustomerCategory(@Param("CustCategory") String cust_category);
}
