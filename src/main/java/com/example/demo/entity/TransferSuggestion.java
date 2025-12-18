package com.example.demo.entity;
import java.time.LocalDateTime;
import  jakarta.persistence.Id;
public class TransferSuggestion{
    @Id
    private Long id;
    private Integer quantity;
    private String priority;
    private LocalDateTime suggestedAt;
    private String status = "PENDING";

    public TransferSuggestion(){

    }
    public TransferSuggestion(Long id,Integer quantity,String priority,LocalDateTime suggestedAt,String status){
        this.id = id;
        this.quantity = quantity;
        this.priority = priority;
        this.suggestedAt = suggestedAt;
        this.status = status;
    }

    public void setId(Long id){
        this.id = id;
    }
    public void setQuantity(Integer quantity){
        this.quantity = quantity;
    }
    public void setPriority(String priority){
        this.priority = priority;
    }
    public void setSuggestedAt(LocalDateTime suggestedAt){
        this.suggestedAt = suggestedAt;
    }
    public void setStatus(String status){
        this.status = status;
    }

    public Long getId(){
        return id;
    }
    public Integer getQuantity(){
        return quantity;
    }
    public String getPriority(){
        return priority;
    }
    public String getStatus(){
        return status;
    }
    public LocalDateTime getSuggestedAt(){
        return suggestedAt;
    }
}