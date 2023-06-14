package com.mps.think.setup.service;

import java.util.List;

import com.mps.think.setup.model.ProductInformation;
import com.mps.think.setup.vo.ProductInformationVO;

public interface ProductInformationService {
	
	public List<ProductInformation> getAllProductInformation(Integer pubId);
	public ProductInformation saveProductInformation(ProductInformationVO productInformationVO);
	public ProductInformation updateProductInformation(ProductInformationVO productInformationVO);
	public ProductInformation findByProductInformationId(Integer id);
}
