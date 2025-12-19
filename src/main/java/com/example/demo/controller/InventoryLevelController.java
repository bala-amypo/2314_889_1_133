package com.example.demo.controller;

import com.example.demo.entity.InventoryLevel;
import com.example.demo.service.InventoryLevelService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
public class InventoryLevelController {

    private final InventoryService inventoryService;

    public InventoryLevelController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    // PUT /api/inventory/update?storeId=&productId=&quantity=
    @PutMapping("/update")
    public Inventory updateInventory(
            @RequestParam Long storeId,
            @RequestParam Long productId,
            @RequestParam int quantity) {

        return inventoryService.updateInventory(storeId, productId, quantity);
    }

    // GET /api/inventory/store/{storeId}
    @GetMapping("/store/{storeId}")
    public Inventory getInventoryByStore(@PathVariable Long storeId) {
        return inventoryService.getInventoryByStore(storeId);
    }
}