package com.example.demo.service;
import java.util.List;
import com.example.demo.entity.Store;

public interface Store{
    public void createStore(Store store);
    public Store getStoreById(Long id);
    public List<Store> getAllStores();
}