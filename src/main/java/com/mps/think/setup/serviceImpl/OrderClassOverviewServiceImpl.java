package com.mps.think.setup.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.OrderClassOverview;
import com.mps.think.setup.repo.OrderClassOverviewRepo;
import com.mps.think.setup.service.OrderClassOverviewService;
import com.mps.think.setup.vo.OrderClassOverviewVO;

@Service
public class OrderClassOverviewServiceImpl implements OrderClassOverviewService {

	@Autowired
	private OrderClassOverviewRepo orderClassOverviewRepo;
	
	@Override
	public OrderClassOverview saveOrderClassOverview(OrderClassOverviewVO overview) {
		ObjectMapper mapper = new ObjectMapper();
		OrderClassOverview newOverview = mapper.convertValue(overview, OrderClassOverview.class);
		orderClassOverviewRepo.saveAndFlush(newOverview);
		return newOverview;
	}

	@Override
	public OrderClassOverview updateOrderClassOverview(OrderClassOverviewVO overview) {
		ObjectMapper mapper = new ObjectMapper();
		OrderClassOverview newOverview = mapper.convertValue(overview, OrderClassOverview.class);
		orderClassOverviewRepo.saveAndFlush(newOverview);
		return newOverview;
	}



	@Override
	public OrderClassOverview deleteOrderClassOverviewById(Integer id) {
		OrderClassOverview overview = findOrderClassOverviewById(id);
		if (overview != null) {
			orderClassOverviewRepo.delete(overview);
			return overview;
		}
		return null;
	}

	@Override
	public OrderClassOverview findOrderClassOverviewById(Integer id) {
		Optional<OrderClassOverview> overview = orderClassOverviewRepo.findById(id);
		if(overview.isPresent()) {
			return overview.get();
		}
		return null;
	}

	@Override
	public List<OrderClassOverview> getAllOrderClassOverviewByPubId(Integer pubId) {
		return orderClassOverviewRepo.findByPublisherId(pubId);
	}

	@Override
	public List<OrderClassOverview> getAllOrderClassOverview() {
		return orderClassOverviewRepo.findAll();
	}

	@Override
	public List<OrderClassOverview> getAllOrderClassOverviewByOrderClassId(Integer ocId) {
		return orderClassOverviewRepo.findByOrderClassOcId(ocId);
	}

}
