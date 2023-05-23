package com.mps.think.setup.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.InventoryMapper;
import com.mps.think.setup.repo.InventoryRepository;
import com.mps.think.setup.service.InventoryService;
import com.mps.think.setup.vo.InventoryMapperVO;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;

	@Autowired
	private ObjectMapper mapper;

	@Override
	public InventoryMapper saveInventory(InventoryMapperVO inventory) {
		return inventoryRepository.saveAndFlush(mapper.convertValue(inventory, InventoryMapper.class));
	}

	@Override
	public InventoryMapper updateInventory(InventoryMapperVO inventory) {
		return inventoryRepository.saveAndFlush(mapper.convertValue(inventory, InventoryMapper.class));
	}

	@Override
	public List<InventoryMapper> getAllInventory() {
		return inventoryRepository.findAll();
	}

	@Override
	public InventoryMapper getInventoryById(Integer inventoryId) {
		return inventoryRepository.findById(inventoryId).get();
	}

}
