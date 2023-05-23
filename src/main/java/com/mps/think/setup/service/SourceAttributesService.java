package com.mps.think.setup.service;

import java.util.List;

import com.mps.think.setup.model.SourceAttributes;
import com.mps.think.setup.vo.SourceAttributesVO;

public interface SourceAttributesService {

	public List<SourceAttributes> findAllSourceAttributes();

	public SourceAttributes saveSourceAttribute(SourceAttributesVO sourceAttribute);

	public SourceAttributes updateSourceAttribute(SourceAttributesVO sourceAttribute);

	public SourceAttributes findbySourceAttributeId(Integer sourceAttributeId) throws Exception;
	
//	public SourceAttributes findbySourceAttributeName(Integer sourceAttributeId) throws Exception;

	public SourceAttributes deleteSourceAttribute(Integer id) throws Exception;
	
	public List<SourceAttributes> getAllSourceAttributeForPublisher(Integer pubid);
	
}
