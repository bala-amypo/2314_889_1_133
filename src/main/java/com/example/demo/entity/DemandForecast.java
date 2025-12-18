package com.example.demo.entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;


public class DemandForecast{
    @Id
    private Long id;
    private LocalDate forecastDate;
    @Column(nullable = false)
    private Integer predictedDemand;
    private Double confidenceScore;
}
