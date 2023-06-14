package com.mps.think.setup.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.mps.think.setup.model.RegionList;
import com.mps.think.setup.vo.RegionListVO;

@Service
public interface RegionListService {
	
	public List<RegionList> getAllRegionList();
	
	public RegionList saveRegionList(RegionListVO regionList);

	public RegionList updateRegionList(RegionListVO regionList);

	public RegionList findbyRegionListId(Integer id);
	
	public RegionList deleteByRegionListId(Integer id);

}
