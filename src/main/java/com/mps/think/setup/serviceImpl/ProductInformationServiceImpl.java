package com.mps.think.setup.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.ProductInformation;
import com.mps.think.setup.repo.ProductInformationRepo;
import com.mps.think.setup.service.ProductInformationService;
import com.mps.think.setup.vo.ProductInformationVO;

@Service
public class ProductInformationServiceImpl implements ProductInformationService{
	@Autowired
	ProductInformationRepo productInformationRepo;
	
	@Autowired
	ObjectMapper objectMapper;

	@Override
	public List<ProductInformation> getAllProductInformation(Integer pubId) {
		return productInformationRepo.findByPublisherId(pubId);
	}

	@Override
	public ProductInformation saveProductInformation(ProductInformationVO productInformationVO) {
		return productInformationRepo.saveAndFlush(objectMapper.convertValue(productInformationVO, ProductInformation.class));
	}

	@Override
	public ProductInformation updateProductInformation(ProductInformationVO productInformationVO) {
		return productInformationRepo.saveAndFlush(objectMapper.convertValue(productInformationVO, ProductInformation.class));
	}

	@Override
	public ProductInformation findByProductInformationId(Integer id) {
		Optional<ProductInformation> pInfo=productInformationRepo.findById(id);
		if(pInfo.isPresent()) {
			return pInfo.get();
		}
		return null;
	}
	
	

}
