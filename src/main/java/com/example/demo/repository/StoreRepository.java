package com.example.demo.repository;

import com.example.demo.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;
public interface StoreRepository extends JpaRepository<Store, Long> {}
public interface ProductRepository extends JpaRepository<Product, Long> {}
