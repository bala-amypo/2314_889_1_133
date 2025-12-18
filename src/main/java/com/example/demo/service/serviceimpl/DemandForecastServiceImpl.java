package com.example.demo.service.serviceimpl;

import com.example.demo.entity.DemandForecast;
import com.example.demo.repository.DemandForecastRepository;
import com.example.demo.service.DemandForecastService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service

public class DemandForecastServiceImpl implements DemandForecastService{
    private final DemandForecastRepository demandrepo;

    public DemandForecastServiceImpl(DemandForecastRepository demandrepo){
        this.demandrepo = demandrepo;
    }

    @Override
    public DemandForecast createForecast(DemandForecast forecast){
        if(forecast.getForecastDate().isBefore(LocalDate.now())){
            throw new RuntimeException("Forecast date must be in the future");
        }
        return demandrepo.save(forecast);
    }

    @Override
    public DemandForecast getForecast(Long storeId,Long productId){

        boolean flag = true;

        if(demandrepo.findByStoreIdAndProductId(storeId,productId)){
            flag = false;
        }
        if(flag){
            throw new RuntimeException("No forecast found");
        }
        return demandrepo.findByStoreIdAndProductId(storeId,productId);
    }
}