package com.example.demo.service;

import com.example.demo.entity.Store;
import java.util.*;
import com.example.demo.service.Storeservice;
import com.example.demo.repository.Storerepo;
@Service
public class Storeservice{

    private final Storerepo rep;

    public Storeservice(Storerepo rep){
        this.rep = rep;
    }
    
    public Store savedata(Store newfile){
        return rep.save(newfile);
    }
    
    public Store getIdvalue(Long id){
        return rep.findById(id);
    }
    
    public List<Store> getall(){
        return rep.findAll();
    }
    
    public Store update(Long id,Store newfile){
        Store existing = rep.findById(id).orElse(null);

        if (existing != null) {
            existing.setName(newfile.getName());
            existing.setEmail(newfile.getEmail());
            return rep.save(existing);
        }
        return null;
    }
    @Override
    public void del(Long id){
        rep.deleteById(id); 
    }
}