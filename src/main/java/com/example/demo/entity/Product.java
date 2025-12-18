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
    public Product(Long id,String sku,String name,String category,boolean active){
        this.id = id;
        this.sku = sku;
        this.name = name;
        this.category = category;
        this.active = active;

    }

    public void setId(){
        this.id = id;
    }
    public void setName(){
        this.name = name;
    }
    public void setSku(St){
        this.sku = sku
    }
    public void setCategory(String category){
        this.category = category;
    }
    public void setActive(boolean active){
        this.active = active;
    }
}