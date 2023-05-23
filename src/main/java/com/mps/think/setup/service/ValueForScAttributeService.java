package com.mps.think.setup.service;

import java.util.List;


import com.mps.think.setup.model.ValueForScAttribute;

import com.mps.think.setup.vo.ValueForScAttributeVO;

public interface ValueForScAttributeService {
	
	public List<ValueForScAttribute> findAllValueForScAttribute();

	public ValueForScAttributeVO saveValueForScAttribute(ValueForScAttributeVO valueForScAttribute);

	public ValueForScAttributeVO updateValueForScAttribute(ValueForScAttributeVO valueForScAttribute);

	public ValueForScAttribute findbyId(Integer id);
	
	public ValueForScAttribute deleteById(Integer id);

}
