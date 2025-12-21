package com.example.demo.service;

import com.example.demo.entity.TransferSuggestion;
import java.util.List;

public interface InventoryBalancerService {
    List<TransferSuggestion> generateSuggestions(Long productId);
    List<TransferSuggestion> getSuggestionsForStore(Long storeId);

    /**
     * Get a specific transfer suggestion by its ID
     * @param id - ID of the transfer suggestion
     * @return TransferSuggestion
     */
    TransferSuggestion getSuggestionById(Long id);
}
