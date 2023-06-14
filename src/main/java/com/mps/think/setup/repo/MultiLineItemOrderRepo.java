package com.mps.think.setup.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mps.think.setup.model.MultiLineItemOrder;
import com.mps.think.setup.model.Order;

public interface MultiLineItemOrderRepo extends JpaRepository<MultiLineItemOrder, Integer> {

	MultiLineItemOrder findByOrderOrderId(Integer orderId);
	
//	List<MultiLineItemOrder> findByParentOrderId(Integer parentId);
	
	@Query("SELECT o FROM MultiLineItemOrder m JOIN m.order o WHERE m.parentOrderId = :parentId")
	Page<Order> findOrdersByParentOrderId(@Param("parentId") Integer parentId, Pageable page);
	
}
