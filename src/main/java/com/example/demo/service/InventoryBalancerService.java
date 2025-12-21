package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.InventoryLevel;

public interface InventoryLevelService {

    InventoryLevel createOrUpdateInventory(InventoryLevel inventory);

    List<InventoryLevel> getInventoryForStore(Long storeId);

    List<InventoryLevel> getInventoryForProduct(Long productId);

    InventoryLevel getInventory(Long storeId, Long productId);
}
