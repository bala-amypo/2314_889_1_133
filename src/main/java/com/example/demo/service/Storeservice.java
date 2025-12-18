package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Store;
import com.example.demo.repository.Storerepo;

@Service
public class StoreserviceImpl implements Storeservice {

    private final Storerepo rep;

    public StoreserviceImpl(Storerepo rep) {
        this.rep = rep;
    }

    @Override
    public Store savedata(Store store) {
        return rep.save(store);
    }

    @Override
    public Store getIdvalue(Long id) {
        return rep.findById(id).orElse(null);
    }

    @Override
    public List<Store> getall() {
        return rep.findAll();
    }

    @Override
    public Store update(Long id, Store newStore) {
        Store existing = rep.findById(id).orElse(null);

        if (existing != null) {
            existing.setStoreName(newStore.getStoreName());
            existing.setAddress(newStore.getAddress());
            existing.setRegion(newStore.getRegion());
            existing.setActive(newStore.isActive());
            return rep.save(existing);
        }
        return null;
    }

    @Override
    public void del(Long id) {
        rep.deleteById(id);
    }
}
