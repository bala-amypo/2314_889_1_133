package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Store;
import com.example.demo.repository.Storerepo;

@Service
public class Storeservice {

    private final Storerepo rep;

    public Storeservice(Storerepo rep) {
        this.rep = rep;
    }

    public Store savedata(Store store) {
        return rep.save(store);
    }

    public Store getIdvalue(Long id) {
        return rep.findById(id).orElse(null);
    }

    public List<Store> getall() {
        return rep.findAll();
    }

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

    public void del(Long id) {
        rep.deleteById(id);
    }
}
