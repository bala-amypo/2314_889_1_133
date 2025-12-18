package com.example.demo.entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta
public class Product{
    @Id
    private Long id;
    @Column(name=unique)
    @
    private String sku;
    private String name;
    private String category;
    private boolean active = true;
}