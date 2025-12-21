package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.TransferSuggestion;
import com.example.demo.service.InventoryBalancerService;

@RestController
@RequestMapping("/api/suggestions")
public class TransferSuggestionController {

    private final InventoryBalancerService inventoryBalancerService;

    public TransferSuggestionController(
            InventoryBalancerService inventoryBalancerService) {
        this.inventoryBalancerService = inventoryBalancerService;
    }

    // Generate transfer suggestions for a product
    @PostMapping("/generate/{productId}")
    public ResponseEntity<List<TransferSuggestion>> generateSuggestions(
            @PathVariable Long productId) {
        return ResponseEntity.ok(
                inventoryBalancerService.generateSuggestions(productId));
    }

    // Get suggestions for a store
    @GetMapping("/store/{storeId}")
    public ResponseEntity<List<TransferSuggestion>> getSuggestionsForStore(
            @PathVariable Long storeId) {
        return ResponseEntity.ok(
                inventoryBalancerService.getSuggestionsForStore(storeId));
    }

    // Get suggestion by ID
    @GetMapping("/{id}")
    public ResponseEntity<TransferSuggestion> getSuggestionById(
            @PathVariable Long id) {
        return ResponseEntity.ok(
                inventoryBalancerService.getSuggestionById(id));
    }
}
