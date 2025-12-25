package com.example.demo.repository;

import com.example.demo.entity.Product;
import com.example.demo.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
public interface StoreRepository extends JpaRepository<Store, Long> {}
public interface ProductRepository extends JpaRepository<Product, Long> {}