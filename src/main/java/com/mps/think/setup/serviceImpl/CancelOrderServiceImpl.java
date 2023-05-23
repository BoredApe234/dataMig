package com.mps.think.setup.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.CancelOrder;
import com.mps.think.setup.repo.CancelOrderRepo;
import com.mps.think.setup.service.CancelOrderService;
import com.mps.think.setup.vo.CancelOrderVO;

@Service
public class CancelOrderServiceImpl implements CancelOrderService {
	
	@Autowired
	private CancelOrderRepo cancelOrderRepo;
	
	@Override
	public List<CancelOrder> getAllCancelOrder() {
		return cancelOrderRepo.findAll();
	}

	@Override
	public CancelOrderVO saveCancelOrder(CancelOrderVO cancelOrder) {
		ObjectMapper mapper = new ObjectMapper();
		CancelOrder newCancelOrder = mapper.convertValue(cancelOrder, CancelOrder.class);
		CancelOrder data=cancelOrderRepo.saveAndFlush(newCancelOrder);
		newCancelOrder.setCancelorderId(data.getCancelorderId());
		return cancelOrder;
	}
	
	@Override
	public CancelOrderVO updateCancelOrder(CancelOrderVO cancelOrder) {
		ObjectMapper mapper = new ObjectMapper();
		CancelOrder cancelOrderToUpdate = mapper.convertValue(cancelOrder, CancelOrder.class);
		CancelOrder data=cancelOrderRepo.saveAndFlush(cancelOrderToUpdate);
		cancelOrder.setCancelorderId(data.getCancelorderId());
		return cancelOrder;
	}
	
	@Override
	public CancelOrder findbyCancelOrderId(Integer cancelOrder) {
		 Optional<CancelOrder> cr = cancelOrderRepo.findById(cancelOrder);
			return cr.get();
	}
	
	@Override
	public List<CancelOrder> getAllCancelOrderByCancelorderId(Integer cancelOrder) {
		return cancelOrderRepo.findByOrderidOrderId(cancelOrder);
	}

}
