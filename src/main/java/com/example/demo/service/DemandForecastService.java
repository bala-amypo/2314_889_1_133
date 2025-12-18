package com.example.demo.service;
import java.util.List;
import com.example.demo.entity.DemandForecastService;

public interface DemandForecastService{
    DemandForecast createForecast(DemandForecast forecast);
    DemandForecast getForecast(Long storeId,Long productId);
}