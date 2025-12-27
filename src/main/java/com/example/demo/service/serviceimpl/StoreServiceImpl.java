package com.example.demo.service;

import com.example.demo.entity.Store;
import com.example.demo.repository.StoreRepository;
import org.springframework.stereotype.Service;
import com.example.demo.service.StoreService;
import java.util.List;
import java.util.Optional; // only if you use Optional anywhere

@Service
public class StoreServiceImpl extends StoreService{

    private final StoreRepository repo;

    public StoreService(StoreRepository repo) {
        this.repo = repo;
    }

    public Store createStore(Store s) {
        if (s.getActive() == null) {
            s.setActive(true);   // default required by tests
        }
        return repo.save(s);
    }

    public List<Store> getAllStores() {
        return repo.findAll();
    }

    public Store updateStore(Long id, Store updated) {
        Store s = repo.findById(id).orElseThrow();
        s.setRegion(updated.getRegion());
        s.setAddress(updated.getAddress());
        s.setStoreName(updated.getStoreName());
        return repo.save(s);
    }

    public void deactivateStore(Long id) {
        Store s = repo.findById(id).orElseThrow();
        s.setActive(false);
        repo.save(s);   // do NOT delete
    }

    public Store getStoreById(Long id) {
        return repo.findById(id).orElseThrow();
    }
}