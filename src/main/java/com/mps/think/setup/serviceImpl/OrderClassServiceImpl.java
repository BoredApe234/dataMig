package com.mps.think.setup.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mps.think.setup.model.OrderClass;
import com.mps.think.setup.model.Publisher;
import com.mps.think.setup.repo.OrderClassRepo;
import com.mps.think.setup.service.OrderClassService;
import com.mps.think.setup.vo.OrderClassVO;
@Service
public class OrderClassServiceImpl implements OrderClassService{
	
	@Autowired
	OrderClassRepo orderClassRepo;

	@Override
	public List<OrderClass> findAllOrderClass() {
		return orderClassRepo.findAll();
	}

	@Override
	public OrderClassVO saveOrderClass(OrderClassVO orderClassVO) {
		OrderClass data=new OrderClass();
		Publisher pub=new Publisher();
		pub.setId(orderClassVO.getPubId().getId());
		data.setPubId(pub);
		data.setOrderClassName(orderClassVO.getOrderClassName());
		data.setOcType(orderClassVO.getOcType());
		data.setDisallowInstallBilling(orderClassVO.getDisallowInstallBilling());
		data.setDoCancelCreditOnCancel(orderClassVO.getDoCancelCreditOnCancel());
		data.setLowSampleStock(orderClassVO.getLowSampleStock());
		data.setLowStock(orderClassVO.getLowStock());
		data.setNewGroupMemberAction(orderClassVO.getNewGroupMemberAction());
		data.setPostConversionReconcile(orderClassVO.getPostConversionReconcile());
		data.setSampleIssueSelection(orderClassVO.getSampleIssueSelection());
		data.setTrackInven(orderClassVO.getTrackInven());
		data.setUpsellOn(orderClassVO.getUpsellOn());
		orderClassRepo.saveAndFlush(data);
		orderClassVO.setOcId(data.getOcId());
		return orderClassVO;
	}

	@Override
	public OrderClassVO updateOrderClass(OrderClassVO orderClassVO) {
		OrderClass data=new OrderClass();
		data.setOcId(orderClassVO.getOcId());
		Publisher pub=new Publisher();
		pub.setId(orderClassVO.getPubId().getId());
		data.setPubId(pub);
		data.setOrderClassName(orderClassVO.getOrderClassName());
		data.setOcType(orderClassVO.getOcType());
		data.setDisallowInstallBilling(orderClassVO.getDisallowInstallBilling());
		data.setDoCancelCreditOnCancel(orderClassVO.getDoCancelCreditOnCancel());
		data.setLowSampleStock(orderClassVO.getLowSampleStock());
		data.setLowStock(orderClassVO.getLowStock());
		data.setNewGroupMemberAction(orderClassVO.getNewGroupMemberAction());
		data.setPostConversionReconcile(orderClassVO.getPostConversionReconcile());
		data.setSampleIssueSelection(orderClassVO.getSampleIssueSelection());
		data.setTrackInven(orderClassVO.getTrackInven());
		data.setUpsellOn(orderClassVO.getUpsellOn());
		orderClassRepo.saveAndFlush(data);
		return orderClassVO;
	}

	@Override
	public OrderClass findbyOrderClassId(Integer orderClassId) {
		return orderClassRepo.findById(orderClassId).get();
	}

	@Override
	public List<OrderClass> findAllOrderClassByPubId(Integer pubId) {
		return orderClassRepo.findAllOrderClassByPubId(pubId);
	}

}
