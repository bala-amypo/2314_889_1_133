package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.*;

@Entity
@Table (name = "Store")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String storeName;
    private String address;
    private String region;
    private boolean active = true;

    
    public Store() {
    }

    
    public Store(Long id, String storeName, String address, String region, boolean active) {
        this.id = id;
        this.storeName = storeName;
        this.address = address;
        this.region = region;
        this.active = active;
    }

    
    public Long getId() {
        return id;
    }

    public String getStoreName() {
        return storeName;
    }

    public String getAddress() {
        return address;
    }

    public String getRegion() {
        return region;
    }

    public boolean isActive() {
        return active;
    }

    
    public void setId(Long id) {
        this.id = id;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
