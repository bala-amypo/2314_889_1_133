package com.example.demo.controller;

import com.example.demo.entity.Forecast;
import com.example.demo.service.ForecastService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/forecasts")
public class DemandForecastController {

    private final ForecastService forecastService;

    public DemandForecastController(ForecastService forecastService) {
        this.forecastService = forecastService;
    }

    // POST /api/forecasts
    @PostMapping
    public Forecast createForecast(@RequestBody Forecast forecast) {
        return forecastService.createForecast(forecast);
    }

    // GET /api/forecasts/store/{storeId}/product/{productId}
    @GetMapping("/store/{storeId}/product/{productId}")
    public Forecast getForecast(
            @PathVariable Long storeId,
            @PathVariable Long productId) {

        return forecastService.getForecast(storeId, productId);
    }
}