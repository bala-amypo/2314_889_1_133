package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Store;

public interface StoreService {

    Store createStore(Store store);

    Store getStoreById(Long id);

    List<Store> getAllStores();

    Store updateStore(Long id, Store store);

    void deactivateStore(Long id);
}
