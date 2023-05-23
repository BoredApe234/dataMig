package com.mps.think.setup.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.SourceAttributeValues;
import com.mps.think.setup.repo.SourceAttributeValuesRepo;
import com.mps.think.setup.service.SourceAttributeValuesService;
import com.mps.think.setup.vo.SourceAttributeValuesVO;

@Service
public class SourceAttributeValuesServiceImpl implements SourceAttributeValuesService {

	@Autowired
	SourceAttributeValuesRepo sourceAttributeRepo;

	@Override
	public List<SourceAttributeValues> findAllSourceAttribute() {
		return sourceAttributeRepo.findAll();
	}

	@Override
	public SourceAttributeValues saveSourceAttribute(SourceAttributeValuesVO sourceAttributeVo) {
		ObjectMapper mapper = new ObjectMapper();
		SourceAttributeValues sourceAttribute = mapper.convertValue(sourceAttributeVo, SourceAttributeValues.class);
		return sourceAttributeRepo.saveAndFlush(sourceAttribute);
	}

	@Override
	public SourceAttributeValues updateSourceAttribute(SourceAttributeValuesVO sourceAttributeVo) {
		ObjectMapper mapper = new ObjectMapper();
		SourceAttributeValues sourceAttribute = mapper.convertValue(sourceAttributeVo, SourceAttributeValues.class);
		return sourceAttributeRepo.saveAndFlush(sourceAttribute);
	}

	@Override
	public SourceAttributeValues findbySourceAttributeId(Integer sourceAttributeId) throws Exception {
		Optional<SourceAttributeValues> sourceAttr = sourceAttributeRepo.findById(sourceAttributeId);
		if (sourceAttr.isPresent()) {
			return sourceAttr.get();
		}
		throw new NotFoundException();
	}

	@Override
	public SourceAttributeValues deleteSourceAttributeById(Integer id) throws Exception {
		Optional<SourceAttributeValues> sourceAttr = sourceAttributeRepo.findById(id);
		if (sourceAttr.isPresent()) {
			sourceAttributeRepo.delete(sourceAttr.get());
			return sourceAttr.get();
		}
		throw new NotFoundException();
	}

	@Override
	public List<SourceAttributeValues> getAllSourceAttributeValuesByScId(Integer id) {
		return sourceAttributeRepo.findBySourceAttributesIdId(id);
	}

	@Override
	public List<SourceAttributeValues> getAllSourceAttributeValuesForPub(Integer pubid) {
		return sourceAttributeRepo.findByPublisherId(pubid);
	}

}
