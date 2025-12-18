package com.example.demo.entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import java.time.LocalDate
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

    public void setId(Long id){
        this.id = id;
    }
    public void setForecastDate(LocalDate forecastdate){
        this.forecastDate = forecastDate;
    }
    public void setPredictedDemand(Integer predictedDemand){
        this.predictedDemand = predictedDemand;
    }
    public void setConfidenceScore(Double confidenceScore){
        this.confidenceScore = confidenceScore;
    }

    public Long setId(){
        return id;
    }
    public Localdate setForecastDate(){
        return forecastDate;
    }
    public Integer setPredictedDemand(){
        return predictedDemand;
    }
    public Double setConfidenceScore(){
        return confidenceScore;
    }
}
