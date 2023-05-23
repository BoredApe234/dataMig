package com.mps.think.setup.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mps.think.setup.model.InventoryMapper;
import com.mps.think.setup.vo.InventoryMapperVO;

@Service
public interface InventoryService {
	
	public InventoryMapper saveInventory(InventoryMapperVO inventory);
	public InventoryMapper updateInventory(InventoryMapperVO inventory);
	public List<InventoryMapper> getAllInventory();
	public InventoryMapper getInventoryById(Integer inventoryId);

}
