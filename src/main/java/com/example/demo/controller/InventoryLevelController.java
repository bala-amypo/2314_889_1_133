package com.example.demo.controller;

import com.example.demo.entity.InventoryLevel;
import com.example.demo.service.InventoryLevelService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
public class InventoryLevelController {

    private final InventoryLevelService inventoryService;

    public InventoryLevelController(InventoryLevelService inventoryService) {
        this.inventoryService = inventoryService;
    }
    @PutMapping("/update")
    public InventoryLevel UpdateInventory(
            @RequestParam Long storeId,
            @RequestParam Long productId,
            @RequestParam int quantity) {

        return inventoryService.updateInventory(storeId, productId, quantity);
    }
    @GetMapping("/store/{storeId}")
    public InventoryLevel Getinventoryfortore(@PathVariable Long storeId) {
        return inventoryService.getInventoryByStore(storeId);
    }
}