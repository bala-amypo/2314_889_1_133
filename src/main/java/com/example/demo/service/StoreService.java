package com.example.demo.service;
import java.util.List;
import java.util.Optional;
import com.example.demo.entity.Store;

public interface StudentService{
    Store createStore(Store store);
    Store getStoreById(Long id);
    List<Store> getAllStores();
}