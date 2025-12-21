package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.DemandForecast;

public interface DemandForecastService {

    DemandForecast createForecast(DemandForecast forecast);

    List<DemandForecast> getForecastsForStore(Long storeId);

    DemandForecast getForecast(Long storeId, Long productId);
}
