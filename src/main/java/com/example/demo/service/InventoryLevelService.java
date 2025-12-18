package com.example.demo.service;
import java.util.List;
import com.example.demo.entity.InventoryLevelService;

public interface InventoryLevelService{
    public void updateInventory(Long storeId,Long productId,Integer quantity);
    public Product getProductById(Long id);
    public List<Product> getAllProducts();
}