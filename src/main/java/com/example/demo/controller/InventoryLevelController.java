package com.example.demo.controller;

import com.example.demo.entity.InventoryLevel;
import com.example.demo.service.InventoryLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private InventoryLevelService inventoryLevelService;

    @PostMapping
    public InventoryLevel createOrUpdateInventory(@RequestBody InventoryLevel inventory) {
        return inventoryLevelService.createOrUpdateInventory(inventory);
    }
}
