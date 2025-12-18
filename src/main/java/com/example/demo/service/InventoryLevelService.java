package com.example.demo.service;
import java.util.List;
import com.example.demo.entity.InventoryLevelService;

public interface InventoryLevelService{
     void updateInventory(Long storeId,Long productId,Integer quantity);
     InventoryLevel getInventory(Long storeId,Long productId);
     InventoryLevel getInventoryByStore(Long storeId);
}