package com.example.demo.service;
import java.util.List;
import com.example.demo.entity.InventoryLevelService;

public interface InventoryLevelService{
    public void updateInventory(Long storeId,Long productId,Integer quantity);
    public InventoryLevel getInventory(Long storeId,Long productId);
    public InventoryLevel getInventoryByStore(Long storeId);
}