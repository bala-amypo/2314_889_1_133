package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.InventoryLevel;
import com.example.demo.entity.Product;
import com.example.demo.entity.Store;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.InventoryLevelRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.StoreRepository;
import com.example.demo.service.InventoryLevelService;

@Service
public class InventoryLevelServiceImpl implements InventoryLevelService {

    private final InventoryLevelRepository inventoryLevelRepository;
    private final StoreRepository storeRepository;
    private final ProductRepository productRepository;

    public InventoryLevelServiceImpl(
            InventoryLevelRepository inventoryLevelRepository,
            StoreRepository storeRepository,
            ProductRepository productRepository) {
        this.inventoryLevelRepository = inventoryLevelRepository;
        this.storeRepository = storeRepository;
        this.productRepository = productRepository;
    }

    @Override
    public InventoryLevel createOrUpdateInventory(InventoryLevel inventoryLevel) {

        if (inventoryLevel.getQuantity() < 0) {
            throw new BadRequestException("Quantity must be >= 0");
        }

        Store store = storeRepository.findById(
                inventoryLevel.getStore().getId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Store not found"));

        Product product = productRepository.findById(
                inventoryLevel.getProduct().getId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product not found"));

        return inventoryLevelRepository
                .findByStoreAndProduct(store, product)
                .map(existing -> {
                    existing.setQuantity(inventoryLevel.getQuantity());
                    return inventoryLevelRepository.save(existing);
                })
                .orElseGet(() -> {
                    inventoryLevel.setStore(store);
                    inventoryLevel.setProduct(product);
                    return inventoryLevelRepository.save(inventoryLevel);
                });
    }

    @Override
    public List<InventoryLevel> getInventoryForStore(Long storeId) {

        storeRepository.findById(storeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Store not found"));

        return inventoryLevelRepository.findByStore_Id(storeId);
    }

    @Override
    public List<InventoryLevel> getInventoryForProduct(Long productId) {

        productRepository.findById(productId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product not found"));

        return inventoryLevelRepository.findByProduct_Id(productId);
    }

    @Override
    public InventoryLevel getInventory(Long storeId, Long productId) {

        Store store = storeRepository.findById(storeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Store not found"));

        Product product = productRepository.findById(productId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product not found"));

        return inventoryLevelRepository
                .findByStoreAndProduct(store, product)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Inventory not found"));
    }
}
