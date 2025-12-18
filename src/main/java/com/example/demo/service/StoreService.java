package com.example.demo.service;
import java.util.List;
import com.example.demo.entity.Store;

public interface Store{
     Store createStore(Store store);
     Store getStoreById(Long id);
     List<Store> getAllStores();
}