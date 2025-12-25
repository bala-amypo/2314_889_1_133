package com.example.demo.service;

import com.example.demo.entity.InventoryBalancer;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.TransferSuggestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InventoryBalancerService {

    private final ProductRepository productRepo;
    private final InventoryLevelRepository inventoryRepo;
    private final DemandForecastRepository forecastRepo;
    private final TransferSuggestionRepository suggestionRepo;

    public InventoryBalancerService(ProductRepository productRepo,
                                    InventoryLevelRepository inventoryRepo,
                                    DemandForecastRepository forecastRepo,
                                    TransferSuggestionRepository suggestionRepo) {
        this.productRepo = productRepo;
        this.inventoryRepo = inventoryRepo;
        this.forecastRepo = forecastRepo;
        this.suggestionRepo = suggestionRepo;
    }

    public List<TransferSuggestion> generateSuggestions(Long productId) {
        Product p = productRepo.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        if (!p.isActive())
            throw new BadRequestException("Inactive product");

        List<InventoryLevel> inv = inventoryRepo.findByProduct_Id(productId);
        List<DemandForecast> fc = forecastRepo.findByProduct_Id(productId);

        if (inv.size() < 2 || fc.isEmpty()) return List.of();

        InventoryLevel over = inv.get(0);
        InventoryLevel under = inv.get(inv.size() - 1);

        TransferSuggestion ts = new TransferSuggestion();
        ts.setProduct(p);
        ts.setSourceStore(over.getStore());
        ts.setTargetStore(under.getStore());
        ts.setSuggestedQuantity(10);
        ts.setReason("Auto balance");

        return List.of(suggestionRepo.save(ts));
    }

    public TransferSuggestion getSuggestionById(Long id) {
        return suggestionRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Suggestion not found"));
    }
}
