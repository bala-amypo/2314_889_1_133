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

    public DemandForecast(){

    }
    public DemandForecast(Long id,LocalDate forecastDate,Integer predictedDemand,Double confidenceScore){
        this.id = id;
        this.forecastDate = forecastDate;
        this.predictedDemand = predictedDemand;
        this.confidenceScore = confidenceScore;
    }

    public void setId(){

    }
}
