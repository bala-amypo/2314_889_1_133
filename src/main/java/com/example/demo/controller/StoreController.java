package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Store;
import com.example.demo.service.StoreService;
import java.util.*;
@RestController
@RequestMapping("/api/stores")

public class StoreController{
    @Autowired
    StoreService src;
    @PostMapping("/POST")
    public Store postData(@RequestBody Store st){
        return src.createStore(st);
    }
    @GetMapping
    public List<Store> getData(){
        return src.getAllStores();
    }
    @GetMapping("/{id}")
    public Store sepData(@PathVariable int id){
        return src.getStoreById(id);

    }
     
}
