package com.example.demo.entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
public class InventoryLevel{
    @Id
    private Long id;
    @PositiveOrZero
    private Integer quantity;
    private LocalDate lastUpdated;
}