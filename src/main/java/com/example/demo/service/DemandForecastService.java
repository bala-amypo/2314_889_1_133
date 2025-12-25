package com.example.demo.service;

import com.example.demo.entity.Store;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.StoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DemandForecastService {

    private final DemandForecastRepository repo;

    public DemandForecastService(DemandForecastRepository repo) {
        this.repo = repo;
    }

    public DemandForecast createForecast(DemandForecast f) {
        if (f.getForecastDate().isBefore(java.time.LocalDate.now()))
            throw new BadRequestException("Past date not allowed");
        return repo.save(f);
    }

    public List<DemandForecast> getForecastsForStore(Long storeId) {
        return repo.findByStore_Id(storeId);
    }
}
