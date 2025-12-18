package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.InventoryLevel;

public interface InventoryLevelRepository extends JpaRepository<InventoryLevel, Long> {
}
