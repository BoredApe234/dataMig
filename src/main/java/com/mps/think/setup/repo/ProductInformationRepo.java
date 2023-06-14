package com.mps.think.setup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.ProductInformation;

@Repository
public interface ProductInformationRepo extends JpaRepository<ProductInformation, Integer>{
	
	List<ProductInformation> findByPublisherId(Integer pubId);

}
