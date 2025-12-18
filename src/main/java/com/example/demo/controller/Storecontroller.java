package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Store;
import com.example.demo.service.Storeservice;

@RestController
public class Storecontroller {

    @Autowired
    private Storeservice src;

    @PostMapping("/post")
    public Store postData(@RequestBody Store st) {
        return src.savedata(st);
    }

    @GetMapping("/getting")
    public List<Store> alldata() {
        return src.getall();
    }

    @GetMapping("/getid/{id}")
    public Store indid(@PathVariable Long id) {
        return src.getIdvalue(id);
    }

    @PutMapping("/update/{id}")
    public Store updatedata(@PathVariable Long id, @RequestBody Store st) {
        return src.update(id, st);
    }

    @DeleteMapping("/delete/{id}")
    public void deletedata(@PathVariable Long id) {
        src.del(id);
    }
}
