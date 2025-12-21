package com.example.demo.service;

import com.example.demo.entity.TransferSuggestion;
import java.util.List;

public interface InventoryBalancerService {

    /**
     * Generate transfer suggestions for a given product across stores
     * @param productId - ID of the product
     * @return List of TransferSuggestion
     */
    List<TransferSuggestion> generateSuggestions(Long productId);

    /**
     * Get all transfer suggestions for a specific store
     * @param storeId - ID of the store
     * @return List of TransferSuggestion
     */
    List<TransferSuggestion> getSuggestionsForStore(Long storeId);

    /**
     * Get a specific transfer suggestion by its ID
     * @param id - ID of the transfer suggestion
     * @return TransferSuggestion
     */
    TransferSuggestion getSuggestionById(Long id);
}
