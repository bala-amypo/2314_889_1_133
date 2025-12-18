package com.example.demo.service;
import java.util.List;
import com.example.demo.entity.DemandForecastService;

public interface DemandForecastService{
    public void createForecast(DemandForecast forecast);
    public DemandForecast getForecast(Long storeId,Long productId);
}