package com.example.OneToMany.entity;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(
    name = "stores",
    uniqueConstraints = @UniqueConstraint(columnNames = "storeName")
)
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String storeName;

    private String address;
    private String region;

    @Column(nullable = false)
    private Boolean active = true;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InventoryLevel> inventoryLevels = new ArrayList<>();

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

    public Boolean getActive() {
        return active;
    }

    public List<InventoryLevel> getInventoryLevels() {
        return inventoryLevels;
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

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void setInventoryLevels(List<InventoryLevel> inventoryLevels) {
        this.inventoryLevels = inventoryLevels;
    }
}
