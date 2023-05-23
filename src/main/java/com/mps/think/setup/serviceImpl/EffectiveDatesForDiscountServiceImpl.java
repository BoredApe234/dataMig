package com.mps.think.setup.serviceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.EffectiveDatesForDiscount;
import com.mps.think.setup.repo.EffectiveDatesForDiscountRepo;
import com.mps.think.setup.service.EffectiveDatesForDiscountService;
import com.mps.think.setup.vo.EffectiveDatesForDiscountVO;

@Service
public class EffectiveDatesForDiscountServiceImpl implements EffectiveDatesForDiscountService {

	@Autowired
	private EffectiveDatesForDiscountRepo effectiveDatesForDiscountRepo;
	
	@Override
	public EffectiveDatesForDiscount saveEffectiveDateForDiscount(EffectiveDatesForDiscountVO effectiveDateForDiscount) {
		ObjectMapper mapper = new ObjectMapper();
		return effectiveDatesForDiscountRepo.saveAndFlush(mapper.convertValue(effectiveDateForDiscount, EffectiveDatesForDiscount.class));
	}

	@Override
	public EffectiveDatesForDiscount updateEffectiveDatesForDiscount(EffectiveDatesForDiscount effectiveDateForDiscount) {
		ObjectMapper mapper = new ObjectMapper();
		return effectiveDatesForDiscountRepo.saveAndFlush(mapper.convertValue(effectiveDateForDiscount, EffectiveDatesForDiscount.class));
	}

	@Override
	public EffectiveDatesForDiscount deleteEffectiveDatesForDiscountById(Integer id) {
		Optional<EffectiveDatesForDiscount> effectiveDate = effectiveDatesForDiscountRepo.findById(id);
		if(effectiveDate.isPresent()) {
			effectiveDatesForDiscountRepo.delete(effectiveDate.get());
			return effectiveDate.get();
		}
		return null;
	}

	@Override
	public List<EffectiveDatesForDiscount> getEffectiveDatesForDiscountCard(Integer discountCardInfoId) {
//		return effectiveDatesForDiscountRepo.findByDiscountCardId(discountCardInfoId, Sort.by(Sort.Direction.ASC, "effectiveDate"));
		List<EffectiveDatesForDiscount> effectiveDates = effectiveDatesForDiscountRepo.findByDiscountCardIdId(discountCardInfoId);
		Collections.sort(effectiveDates, new Comparator<EffectiveDatesForDiscount>() {
		    public int compare(EffectiveDatesForDiscount m1, EffectiveDatesForDiscount m2) {
		        return m1.getEffectiveDate().compareTo(m2.getEffectiveDate());
		    }
		});
		return effectiveDates;
	}

	@Override
	public void deleteEffectiveDatesForDiscountCard(Integer discountCardId) {
		for (EffectiveDatesForDiscount effectiveDate : getEffectiveDatesForDiscountCard(discountCardId)) {
			deleteEffectiveDatesForDiscountById(effectiveDate.getId());
		}
	}

	@Override
	public List<EffectiveDatesForDiscount> getAllEffectiveDates() {
		return effectiveDatesForDiscountRepo.findAll();
	}

	@Override
	public EffectiveDatesForDiscount getEffectiveDateById(Integer id) {
		Optional<EffectiveDatesForDiscount> effectiveDate = effectiveDatesForDiscountRepo.findById(id);
		if (effectiveDate.isPresent()) return effectiveDate.get();
		return null;
	}

}
