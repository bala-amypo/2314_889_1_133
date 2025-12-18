package com.example.demo.entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.NotBlank;
@Entity
public class Product{
    @Id
    private Long id;
    @Column(name=unique)
    @NotBlank
    private String sku;
    private String name;
    private String category;
    private boolean active = true;

    public Product(){

    }
    public Product(){
        
    }
}