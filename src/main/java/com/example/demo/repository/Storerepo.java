package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Store;

public interface Storerepo extends JpaRepository<Store, Long> {
}
