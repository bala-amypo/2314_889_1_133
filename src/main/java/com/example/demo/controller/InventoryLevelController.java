package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.InventoryLevel;
import com.example.demo.service.InventoryLevelService;

@RestController
@RequestMapping("/api/inventory")
public class InventoryLevelController {

    private final InventoryLevelService inventoryLevelService;

    public InventoryLevelController(InventoryLevelService inventoryLevelService) {
        this.inventoryLevelService = inventoryLevelService;
    }

    // Create or update inventory
    @PostMapping
    public ResponseEntity<InventoryLevel> createOrUpdateInventory(
            @RequestBody InventoryLevel inventoryLevel) {
        return ResponseEntity.ok(
                inventoryLevelService.createOrUpdateInventory(inventoryLevel));
    }

    
    @GetMapping("/store/{storeId}")
    public ResponseEntity<List<InventoryLevel>> getInventoryForStore(
            @PathVariable Long storeId) {
        return ResponseEntity.ok(
                inventoryLevelService.getInventoryForStore(storeId));
    }

    // Get inventory for a product
    @GetMapping("/product/{productId}")
    public ResponseEntity<List<InventoryLevel>> getInventoryForProduct(
            @PathVariable Long productId) {
        return ResponseEntity.ok(
                inventoryLevelService.getInventoryForProduct(productId));
    }
}
