package com.example.demo.entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
public class InventoryLevel{
    @Id
    private Long id;
    @PositiveOrZero
    private Integer quantity;
    private LocalDate lastUpdated;

    public InventoryLevel(){

    }
    public InventoryLevel(Long id,Integer quantity,LocalDate lastUpdated){
        this.id = id;
        this.quantity = quantity;
        this.lastUpdated = lastUpdated;
    }

    public void setId(Long id){
        this.id = id;
    }
    public void setQuantity(Integer quantity){
        this.quantity =quantity;
    }
    public void setLastUpdated(LocalDate lastupdated){
        this.lastupdated = 
    }
}