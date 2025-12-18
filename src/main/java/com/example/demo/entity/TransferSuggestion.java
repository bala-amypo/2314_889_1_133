package com.example.demo.entity;
import java.time.LocalDateTime;
import  jakarta.persistence.Id;
public class TransferSuggestion{
    @Id
    private Long id;
    private Integer quantity;
    private String priority;
    private LocalDateTime suggestedAt;
    private String status;
}