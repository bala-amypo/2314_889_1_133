package com.example.demo.service;

import com.example.demo.entity.Store;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.StoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InventoryLevelService {

    private final InventoryLevelRepository repo;

    public InventoryLevelService(InventoryLevelRepository repo) {
        this.repo = repo;
    }

    public InventoryLevel createOrUpdateInventory(InventoryLevel inv) {
        if (inv.getQuantity() < 0)
            throw new BadRequestException("Quantity cannot be negative");

        return repo.findByStore_Id(inv.getStore().getId()).stream()
                .filter(i -> i.getProduct().getId().equals(inv.getProduct().getId()))
                .findFirst()
                .map(existing -> {
                    existing.setQuantity(inv.getQuantity());
                    return repo.save(existing);
                })
                .orElseGet(() -> repo.save(inv));
    }

    public List<InventoryLevel> getInventoryForStore(Long storeId) {
        return repo.findByStore_Id(storeId);
    }

    public List<InventoryLevel> getInventoryForProduct(Long productId) {
        return repo.findByProduct_Id(productId);
    }
}
