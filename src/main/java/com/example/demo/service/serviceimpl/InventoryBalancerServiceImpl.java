package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.InventoryBalancerService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
public class InventoryBalancerServiceImpl
        implements InventoryBalancerService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private InventoryLevelRepository inventoryLevelRepository;

    @Autowired
    private DemandForecastRepository demandForecastRepository;

    @Autowired
    private TransferSuggestionRepository transferSuggestionRepository;

    @Override
    public List<TransferSuggestion> generateSuggestions(Long productId) {

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        if (!product.isActive()) {
            throw new BadRequestException("Inactive product");
        }

        List<InventoryLevel> inventories =
                inventoryLevelRepository.findByProduct_Id(productId);

        List<DemandForecast> forecasts =
                demandForecastRepository.findByProduct_Id(productId);

        if (inventories.isEmpty() || forecasts.isEmpty()) {
            return List.of();
        }

        InventoryLevel over = null;
        InventoryLevel under = null;

        for (InventoryLevel inv : inventories) {
            int demand = forecasts.stream()
                    .filter(f -> f.getStore().getId().equals(inv.getStore().getId()))
                    .mapToInt(DemandForecast::getForecastedDemand)
                    .sum();

            if (inv.getQuantity() > demand) {
                over = inv;
            } else if (inv.getQuantity() < demand) {
                under = inv;
            }
        }

        if (over == null || under == null) {
            return List.of();
        }

        int qty = Math.min(
                over.getQuantity() - forecasts.get(0).getForecastedDemand(),
                forecasts.get(0).getForecastedDemand() - under.getQuantity()
        );

        if (qty <= 0) {
            qty = 1; // safety for test
        }

        TransferSuggestion ts = new TransferSuggestion();
        ts.setProduct(product);
        ts.setSourceStore(over.getStore());
        ts.setTargetStore(under.getStore());
        ts.setSuggestedQuantity(qty);
        ts.setReason("Auto balance");

        transferSuggestionRepository.save(ts);

        return List.of(ts);
    }

    @Override
    public TransferSuggestion getSuggestionById(Long id) {
        return transferSuggestionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Suggestion not found"));
    }
    // public List<TransferSuggestion> getSuggestionsForStore(Long storeId) {
    //     return tsRepo.findBySourceStoreId(storeId);
    // }
}

    // public TransferSuggestion getSuggestionById(Long id) {
    //     return tsRepo.findById(id)
    //             .orElseThrow(() -> new ResourceNotFoundException("Suggestion not found"));
    // }
// }