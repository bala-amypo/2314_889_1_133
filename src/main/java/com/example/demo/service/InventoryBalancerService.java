package com.example.demo.service;
import java.util.List;
import com.example.demo.entity.InventoryLevel;

public interface InventoryLevelBalancer{
    List<InventoryLevel> generateSuggestions(Long productId);
    List<InventoryLevel> generateSuggestionsForStore(Long storeId);
    InventoryLevel getSuggestionById(Long id);
}