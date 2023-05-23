package com.mps.think.setup.service;

import java.util.List;

import com.mps.think.setup.model.DiscountCardKeyInfo;
import com.mps.think.setup.model.RateCards;
import com.mps.think.setup.vo.DiscountCardKeyInfoVO;

public interface DiscountCardKeyInfoService {

	public DiscountCardKeyInfo saveDiscountCard(DiscountCardKeyInfoVO discountCard);

	public DiscountCardKeyInfo updateDiscountCard(DiscountCardKeyInfo discountCard);
	
	public DiscountCardKeyInfo deleteDiscountCardById(Integer id);
	
//	public List<DiscountCardKeyInfo> getAllDiscountCardKeyInfoForParent(Integer id);
	
	List<DiscountCardKeyInfo> getDiscountCardKeyInfosForOrderClass(Integer ocId);
	
	List<DiscountCardKeyInfo> getAllDiscountCards();
	
	DiscountCardKeyInfo getDiscountCardKeyInfoById(Integer id);
	
	public List<DiscountCardKeyInfo> findAllDiscountCardKeyInfoByPublisherId(Integer pubId);
	
}
