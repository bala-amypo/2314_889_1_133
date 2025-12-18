package com.example.demo.service.serviceimpl;
import com.example.demo.entity.InventoryLevel;
import com.example.demo.repository.InventoryLevelRepository;
import com.example.demo.service.InventoryLevelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryLevelServiceImpl implements InventoryLevelService{
    private final InventoryLevelRepository inventoryrepo;

    public InventoryLevelServiceImpl(InventoryLevelRepository inventoryrepo){
        this.inventoryrepo = inventoryrepo;
    }

    @Override
    public InventoryLevel updateInventory(Long storeId,Long productId,Integer quantity){
        if(quantity < 0){
            throw new RuntimeException("Quantity must be >=0");
        }

        InventoryLevel invention = inventoryrepo.findByStoreIdAndProductId(storeId,productId);
        invention.setQuantity(quantity);
        return inventoryrepo.save(invention);
    }

    @Override
    public InventoryLevel getInventory(Long storeId,Long productId){
        return inventoryrepo.findByStoreAndProductId(storeId,productId);
    }
}