package com.mps.think.setup.service;

import java.util.List;


import com.mps.think.setup.model.SourceAttributeValues;
import com.mps.think.setup.vo.SourceAttributeValuesVO;

public interface SourceAttributeValuesService {

	public List<SourceAttributeValues> findAllSourceAttribute();

	public SourceAttributeValues saveSourceAttribute(SourceAttributeValuesVO surceAttributeVo);

	public SourceAttributeValues updateSourceAttribute(SourceAttributeValuesVO sourceAttributeVo);

	public SourceAttributeValues findbySourceAttributeId(Integer sourceAttributeId) throws Exception;
	
	public SourceAttributeValues deleteSourceAttributeById(Integer id) throws Exception;
	
	public List<SourceAttributeValues> getAllSourceAttributeValuesByScId(Integer id);

	public List<SourceAttributeValues> getAllSourceAttributeValuesForPub(Integer pubid);
}
