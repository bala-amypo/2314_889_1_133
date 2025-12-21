package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Store;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.StoreRepository;
import com.example.demo.service.StoreService;

@Service
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;

    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public Store createStore(Store store) {

        storeRepository.findByStoreName(store.getStoreName())
                .ifPresent(s -> {
                    throw new BadRequestException("Store name already exists");
                });

        store.setActive(true);
        return storeRepository.save(store);
    }

    @Override
    public Store getStoreById(Long id) {

        return storeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Store not found"));
    }

    @Override
    public List<Store> getAllStores() {

        return storeRepository.findAll();
    }

    @Override
    public Store updateStore(Long id, Store updatedStore) {

        Store store = storeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Store not found"));

        store.setStoreName(updatedStore.getStoreName());
        store.setAddress(updatedStore.getAddress());
        store.setRegion(updatedStore.getRegion());

        return storeRepository.save(store);
    }

    @Override
    public void deactivateStore(Long id) {

        Store store = storeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Store not found"));

        store.setActive(false);
        storeRepository.save(store);
    }
}
