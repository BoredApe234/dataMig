package com.mps.think.setup.service;

import java.util.List;

import com.mps.think.setup.model.ParentChildMapping;
import com.mps.think.setup.vo.ParentChildMappingVO;

public interface ParentChildMappingService {

	public List<ParentChildMapping> findAllParentChild();

	public ParentChildMappingVO saveAuxVParentChild(ParentChildMappingVO parentChildMappingVO);

	public ParentChildMappingVO updateAuxParentChild(ParentChildMappingVO parentChildMappingVO);

	public ParentChildMapping findbyParentChildMappingId(Integer id);
	
	public List<ParentChildMapping> findAllParentChildByPublisherId(Integer pubId);

}
