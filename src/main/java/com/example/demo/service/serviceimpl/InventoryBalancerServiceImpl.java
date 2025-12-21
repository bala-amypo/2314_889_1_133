package com.example.demo.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.*;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.InventoryBalancerService;

@Service
public class InventoryBalancerServiceImpl implements InventoryBalancerService {

    private final TransferSuggestionRepository transferSuggestionRepository;
    private final InventoryLevelRepository inventoryLevelRepository;
    private final DemandForecastRepository demandForecastRepository;
    private final StoreRepository storeRepository;

    public InventoryBalancerServiceImpl(
            TransferSuggestionRepository transferSuggestionRepository,
            InventoryLevelRepository inventoryLevelRepository,
            DemandForecastRepository demandForecastRepository,
            StoreRepository storeRepository) {
        this.transferSuggestionRepository = transferSuggestionRepository;
        this.inventoryLevelRepository = inventoryLevelRepository;
        this.demandForecastRepository = demandForecastRepository;
        this.storeRepository = storeRepository;
    }

    @Override
    public List<TransferSuggestion> generateSuggestions(Long productId) {

        List<InventoryLevel> inventories =
                inventoryLevelRepository.findByProduct_Id(productId);

        if (inventories.isEmpty()) {
            throw new BadRequestException("No inventory found");
        }

        Product product = inventories.get(0).getProduct();

        if (!Boolean.TRUE.equals(product.getActive())) {
            throw new BadRequestException("Inactive product");
        }

        List<TransferSuggestion> suggestions = new ArrayList<>();

        for (InventoryLevel sourceInv : inventories) {

            List<DemandForecast> forecasts =
                    demandForecastRepository.findByStoreAndProductAndForecastDateAfter(
                            sourceInv.getStore(),
                            product,
                            LocalDate.now());

            if (forecasts.isEmpty()) {
                throw new BadRequestException("No forecast found");
            }

            int predictedDemand =
                    forecasts.stream()
                            .mapToInt(DemandForecast::getPredictedDemand)
                            .sum();

            int surplus = sourceInv.getQuantity() - predictedDemand;

            if (surplus <= 0) continue;

            for (InventoryLevel targetInv : inventories) {

                if (sourceInv.getStore().getId()
                        .equals(targetInv.getStore().getId())) {
                    continue;
                }

                int deficit = predictedDemand - targetInv.getQuantity();

                if (deficit > 0) {

                    TransferSuggestion suggestion = new TransferSuggestion();
                    private Store sourceStore;
                    private Store targetStore;
private Product product;
private int quantity;
private String priority;
private String status;

// Add getters and setters for all fields
;

                    suggestions.add(
                            transferSuggestionRepository.save(suggestion)
                    );
                }
            }
        }

        return suggestions;
    }

    @Override
    public List<TransferSuggestion> getSuggestionsForStore(Long storeId) {

        storeRepository.findById(storeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Store not found"));

        return transferSuggestionRepository.findBySourceStoreId(storeId);
    }

    @Override
    public TransferSuggestion getSuggestionById(Long id) {

        return transferSuggestionRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Suggestion not found"));
    }
}
