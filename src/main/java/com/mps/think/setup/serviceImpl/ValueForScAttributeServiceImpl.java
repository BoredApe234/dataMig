package com.mps.think.setup.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.mps.think.setup.model.ValueForScAttribute;
import com.mps.think.setup.repo.ValueForScAttributeRepo;
import com.mps.think.setup.service.ValueForScAttributeService;
import com.mps.think.setup.vo.ValueForScAttributeVO;

@Service
public class ValueForScAttributeServiceImpl implements ValueForScAttributeService {
	
	@Autowired
	ValueForScAttributeRepo valueForScAttributeRepo;

	@Override
	public List<ValueForScAttribute> findAllValueForScAttribute() {
		return valueForScAttributeRepo.findAll();
	}

	@Override
	public ValueForScAttributeVO saveValueForScAttribute(ValueForScAttributeVO valueForScAttribute) {
		ObjectMapper mapper = new ObjectMapper();
		ValueForScAttribute newValueForScAttribute = mapper.convertValue(valueForScAttribute, ValueForScAttribute.class);
		ValueForScAttribute data=valueForScAttributeRepo.saveAndFlush(newValueForScAttribute);
		valueForScAttribute.setId(data.getId());
		return valueForScAttribute;
	}

	@Override
	public ValueForScAttributeVO updateValueForScAttribute(ValueForScAttributeVO valueForScAttribute) {
		ObjectMapper mapper = new ObjectMapper();
		ValueForScAttribute newValueForScAttributeUpdate = mapper.convertValue(valueForScAttribute, ValueForScAttribute.class);
		ValueForScAttribute data=valueForScAttributeRepo.saveAndFlush(newValueForScAttributeUpdate);
		valueForScAttribute.setId(data.getId());
		return valueForScAttribute;
	}

	@Override
	public ValueForScAttribute findbyId(Integer id) {
		Optional<ValueForScAttribute> cc = valueForScAttributeRepo.findById(id);
		if(!cc.isPresent()) {
			throw new NotFoundException("ValueForScAttribute  Id : "+ id +" does not exist!");
		}
		return cc.get();
	}

	@Override
	public ValueForScAttribute deleteById(Integer id) {
		ValueForScAttribute todelete = findbyId(id);
		valueForScAttributeRepo.delete(todelete);
		return todelete;
	}

}
