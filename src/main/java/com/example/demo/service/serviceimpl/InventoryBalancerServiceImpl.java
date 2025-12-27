package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.InventoryBalancerService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryBalancerServiceImpl implements InventoryBalancerService {

    private final TransferSuggestionRepository tsRepo;
    private final InventoryLevelRepository invRepo;
    private final DemandForecastRepository forecastRepo;
    private final StoreRepository storeRepo;

    public InventoryBalancerServiceImpl(
            TransferSuggestionRepository tsRepo,
            InventoryLevelRepository invRepo,
            DemandForecastRepository forecastRepo,
            StoreRepository storeRepo) {

        this.tsRepo = tsRepo;
        this.invRepo = invRepo;
        this.forecastRepo = forecastRepo;
        this.storeRepo = storeRepo;
    }

    public List<TransferSuggestion> generateSuggestions(Long productId) {

        List<InventoryLevel> inventory = invRepo.findByProduct_Id(productId);
        if (inventory.isEmpty()) {
            throw new BadRequestException("No forecast found");
        }

        Product product = inventory.get(0).getProduct();
        if (!product.isActive()) {
            throw new BadRequestException("Inactive product");
        }

        List<TransferSuggestion> results = new ArrayList<>();

        for (InventoryLevel src : inventory) {
            for (InventoryLevel tgt : inventory) {
                if (!src.getStore().getId().equals(tgt.getStore().getId())) {

                    List<DemandForecast> srcF =
                            forecastRepo.findByStoreAndProductAndForecastDateAfter(
                                    src.getStore(), product, LocalDate.now());

                    List<DemandForecast> tgtF =
                            forecastRepo.findByStoreAndProductAndForecastDateAfter(
                                    tgt.getStore(), product, LocalDate.now());

                    if (!srcF.isEmpty() && !tgtF.isEmpty()) {
                        int surplus = src.getQuantity() - srcF.get(0).getForecastedDemand();
                        int deficit = tgtF.get(0).getForecastedDemand() - tgt.getQuantity();

                        if (surplus > 0 && deficit > 0) {
                            TransferSuggestion ts = new TransferSuggestion();
                            ts.setProduct(product);
                            ts.setSourceStore(src.getStore());
                            ts.setTargetStore(tgt.getStore());
                            ts.setSuggestedQuantity(Math.min(surplus, deficit));
                            ts.setReason("Auto balance");
                            results.add(tsRepo.save(ts));
                        }
                    }
                }
            }
        }

        // if (results.isEmpty()) {
        //     throw new BadRequestException("No forecast found");
        // }

        return results;
    }

    public List<TransferSuggestion> getSuggestionsForStore(Long storeId) {
        return tsRepo.findBySourceStoreId(storeId);
    }

    public TransferSuggestion getSuggestionById(Long id) {
        return tsRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Suggestion not found"));
    }
}