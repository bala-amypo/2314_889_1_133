package com.example.demo.service.impl;

import com.example.demo.entity.DemandForecast;
import com.example.demo.entity.Product;
import com.example.demo.entity.Store;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.DemandForecastRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.StoreRepository;
import com.example.demo.service.DemandForecastService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Service
public class DemandForecastServiceImpl implements DemandForecastService {

    private final DemandForecastRepository demandForecastRepository;
    private final StoreRepository storeRepository;
    private final ProductRepository productRepository;

    public DemandForecastServiceImpl(
            DemandForecastRepository demandForecastRepository,
            StoreRepository storeRepository,
            ProductRepository productRepository) {
        this.demandForecastRepository = demandForecastRepository;
        this.storeRepository = storeRepository;
        this.productRepository = productRepository;
    }

    @Override
    public DemandForecast createForecast(DemandForecast forecast) {
        if (forecast.getForecastDate() == null) {
            throw new BadRequestException("Forecast date cannot be null");
        }

        if (forecast.getForecastDate().isBefore(LocalDate.now())) {
            throw new BadRequestException("Forecast date must be in the future");
        }

        if (forecast.getPredictedDemand() < 0) {
            throw new BadRequestException("Predicted demand must be >= 0");
        }

        if (forecast.getStore() == null || forecast.getProduct() == null) {
            throw new BadRequestException("Forecast must have a store and product assigned");
        }

        return demandForecastRepository.save(forecast);
    }

    @Override
    public List<DemandForecast> getForecastsForStore(Long storeId) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new ResourceNotFoundException("Store not found"));

        return demandForecastRepository.findByStore_Id(store.getId());
    }

    @Override
    public DemandForecast getForecast(Long storeId, Long productId) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new ResourceNotFoundException("Store not found"));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        return demandForecastRepository
                .findByStoreAndProductAndForecastDateAfter(store, product, LocalDate.now())
                .stream()
                .sorted(Comparator.comparing(DemandForecast::getForecastDate))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Forecast not found for this store and product"));
    }
}
