package com.mps.think.setup.service;

import java.util.List;

import com.mps.think.setup.model.EffectiveDatesForDiscount;
import com.mps.think.setup.vo.EffectiveDatesForDiscountVO;

public interface EffectiveDatesForDiscountService {

	public EffectiveDatesForDiscount saveEffectiveDateForDiscount(EffectiveDatesForDiscountVO effectiveDateForDiscount);
	
	public EffectiveDatesForDiscount updateEffectiveDatesForDiscount(EffectiveDatesForDiscount effectiveDateForDiscount);
	
	public EffectiveDatesForDiscount deleteEffectiveDatesForDiscountById(Integer id);
	
	public List<EffectiveDatesForDiscount> getEffectiveDatesForDiscountCard(Integer discountCardInfoId);
	
	public void deleteEffectiveDatesForDiscountCard(Integer discountCardId);
	
	public List<EffectiveDatesForDiscount> getAllEffectiveDates();
	
	public EffectiveDatesForDiscount getEffectiveDateById(Integer id);
	
}
