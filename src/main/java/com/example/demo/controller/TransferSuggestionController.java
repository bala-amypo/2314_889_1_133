package com.example.demo.controller;

import com.example.demo.entity.TransferSuggestion;
import com.example.demo.service.InventoryBalancerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/balancer")
public class InventoryBalancerController {

    @Autowired
    private InventoryBalancerService inventoryBalancerService;

    @GetMapping("/suggest/{productId}")
    public List<TransferSuggestion> generateSuggestions(@PathVariable Long productId) {
        return inventoryBalancerService.generateSuggestions(productId);
    }
}
