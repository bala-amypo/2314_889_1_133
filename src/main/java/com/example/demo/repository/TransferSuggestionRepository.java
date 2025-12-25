package com.example.demo.repository;

import com.example.demo.entity.TransferSuggestion;
import com.example.demo.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
public interface TransferSuggestionRepository extends JpaRepository<TransferSuggestion, Long> {
    List<TransferSuggestion> findByProduct_Id(Long productId);
}