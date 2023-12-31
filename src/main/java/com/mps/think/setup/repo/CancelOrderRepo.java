package com.mps.think.setup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mps.think.setup.model.CancelOrder;

@Repository
public interface CancelOrderRepo extends JpaRepository<CancelOrder ,Integer> {
	
	List<CancelOrder> findByOrderidOrderId(Integer id);

}
