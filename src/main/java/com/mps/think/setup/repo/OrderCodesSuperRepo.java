package com.mps.think.setup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.OrderCodesSuper;

@Repository
public interface OrderCodesSuperRepo extends JpaRepository<OrderCodesSuper, Integer> {

	List<OrderCodesSuper> findByPublisherId(Integer id);

	List<OrderCodesSuper> findByOrderClassOcId(Integer ocId);
}
