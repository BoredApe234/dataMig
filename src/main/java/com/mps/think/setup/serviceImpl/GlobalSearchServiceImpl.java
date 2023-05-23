
package com.mps.think.setup.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mps.think.setup.model.CustomerDetails;
import com.mps.think.setup.model.Order;
import com.mps.think.setup.repo.AddOrderRepo;
import com.mps.think.setup.repo.CustomerDetailsRepo;
//import com.mps.think.setup.service.GlobalSearchService;
import com.mps.think.setup.service.GlobalSearchService;

@Service
public class GlobalSearchServiceImpl implements GlobalSearchService {
	
//	@Autowired
//	private AddOrderRepo orderRepo;
//	
//	@Autowired
//	private CustomerDetailsRepo customerRepo;
//
//	@Override
//	public Map<String, Object> getSearchResults(String keyword, Pageable customersPage) {
//		Map<String, Object> result = new HashMap<>();
////		Page<CustomerDetails> customerResults = customerRepo.getAllCustomerDetailsForSearchSingle(keyword, customersPage);
////		Page<Order> orderResults = orderRepo.findOrdersBySearch(keyword, ordersPage);
////		result.put("customers", customerResults);
////		result.put("orders", orderResults);
//		return result;
//	}


}