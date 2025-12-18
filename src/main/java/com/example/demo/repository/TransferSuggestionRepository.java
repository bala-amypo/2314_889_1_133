package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.TransferSuggestion;

public interface TransferSuggestionRepository extends JpaRepository<TransferSuggestion, Long> {
}
