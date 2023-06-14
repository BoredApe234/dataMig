package com.mps.think.setup.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.RegionList;
import com.mps.think.setup.repo.RegionListRepo;
import com.mps.think.setup.service.RegionListService;
import com.mps.think.setup.vo.RegionListVO;

@Service
public class RegionListServiceImpl implements RegionListService  {
	
	@Autowired
	private RegionListRepo regionListRepo;
	
	@Autowired
	private ObjectMapper mapper;

	@Override
	public List<RegionList> getAllRegionList() {
		return regionListRepo.findAll();
	}

	@Override
	public RegionList saveRegionList(RegionListVO regionList) {
		return regionListRepo.saveAndFlush(mapper.convertValue(regionList, RegionList.class));
	}

	@Override
	public RegionList updateRegionList(RegionListVO regionList) {
		return regionListRepo.saveAndFlush(mapper.convertValue(regionList, RegionList.class));
	}

	@Override
	public RegionList findbyRegionListId(Integer id) {
		return regionListRepo.findById(id).get();
	}

	@Override
	public RegionList deleteByRegionListId(Integer id) {
		RegionList delete = findbyRegionListId(id);
		regionListRepo.delete(delete);
		return delete;
	}

}
