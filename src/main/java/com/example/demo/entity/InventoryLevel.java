package com.example.demo.entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;
public class InventoryLevel{
    @Id
    private Long id;
    @PositiveOrZero
    private Integer quantity;
    private LocalDateTime lastUpdated;

    public InventoryLevel(){

    }
    public InventoryLevel(Long id,Integer quantity,LocalDateTime lastUpdated){
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
    public void setLastupdated(LocalDateTime lastUpdated){
        this.lastUpdated = lastUpdated;
    }

    public Long getId(){
         return id;
    }
    public Integer getQuantity(){
        return quantity;
    }
    public LocalDate getLastupdated(){
        return lastUpdated;
    }
}