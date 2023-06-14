package com.mps.think.setup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mps.think.setup.model.Address;

@Repository
public interface AddressRepo  extends JpaRepository<Address, Integer>{
	
	List<Address> findByPubIdId(Integer pubId);

}
