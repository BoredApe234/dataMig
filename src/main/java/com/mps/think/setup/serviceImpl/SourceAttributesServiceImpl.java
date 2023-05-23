package com.mps.think.setup.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.SourceAttributes;
import com.mps.think.setup.repo.SourceAttributesRepo;
import com.mps.think.setup.service.SourceAttributesService;
import com.mps.think.setup.vo.SourceAttributesVO;
@Service
public class SourceAttributesServiceImpl implements SourceAttributesService {
	
	@Autowired
	private SourceAttributesRepo sourceAttributesRepo;
	
	@Override
	public List<SourceAttributes> findAllSourceAttributes() {
		return sourceAttributesRepo.findAll();
	}

	@Override
	public SourceAttributes saveSourceAttribute(SourceAttributesVO sourceAttribute) {
		ObjectMapper mapper = new ObjectMapper();
		SourceAttributes attribute = mapper.convertValue(sourceAttribute, SourceAttributes.class);
		return sourceAttributesRepo.saveAndFlush(attribute);
	}

	@Override
	public SourceAttributes updateSourceAttribute(SourceAttributesVO sourceAttribute) {
		ObjectMapper mapper = new ObjectMapper();
		SourceAttributes attribute = mapper.convertValue(sourceAttribute, SourceAttributes.class);
		return sourceAttributesRepo.saveAndFlush(attribute);
	}

	@Override
	public SourceAttributes findbySourceAttributeId(Integer sourceAttributeId) throws Exception {
		Optional<SourceAttributes> attribute = sourceAttributesRepo.findById(sourceAttributeId);
		if (attribute.isPresent()) {
			return attribute.get();
		}
		throw new NotFoundException();
	}

	@Override
	public SourceAttributes deleteSourceAttribute(Integer id) throws Exception {
		SourceAttributes attribute = findbySourceAttributeId(id);
		sourceAttributesRepo.delete(attribute);
		return attribute;
	}

	@Override
	public List<SourceAttributes> getAllSourceAttributeForPublisher(Integer pubid) {
		return sourceAttributesRepo.findByPublisherId(pubid);
	}

//	@Override
//	public SourceAttributes findbySourceAttributeName(Integer sourceAttributeId) throws Exception {
//		Optional<SourceAttributes> attribute = sourceAttributesRepo.findById(sourceAttributeId);
//		if (attribute.isPresent()) {
//			return attribute.get();
//		}
//		throw new NotFoundException();
//	}


	
}
