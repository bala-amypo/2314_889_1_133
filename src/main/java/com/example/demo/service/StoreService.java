package com.example.demo.service;

import com.example.demo.entity.Store;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.StoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {

    private final StoreRepository repo;

    public StoreService(StoreRepository repo) {
        this.repo = repo;
    }

    public Store createStore(Store store) {
        return repo.save(store);
    }

    public Store updateStore(Long id, Store update) {
        Store s = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Store not found"));
        s.setStoreName(update.getStoreName());
        s.setAddress(update.getAddress());
        s.setRegion(update.getRegion());
        s.setActive(update.isActive());
        return repo.save(s);
    }

    public void deactivateStore(Long id) {
        Store s = getStoreById(id);
        s.setActive(false);
        repo.save(s);
    }

    public Store getStoreById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Store not found"));
    }

    public List<Store> getAll() {
        return repo.findAll();
    }
}
