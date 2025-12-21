package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import java.util.*;
@RestController
@RequestMapping("/api/products")

public class ProductController{
    @Autowired
    ProductService src;
    @PostMapping
    public Product Createproduct(@RequestBody Product st){
        return src.createProduct(st);
    }
    @GetMapping
    public List<Product> Listproducts(){
        return src.getAllProducts();
    }
    @GetMapping("/{id}")
    public Product Getproduct(@PathVariable Long id){
        return src.getProductById(id);

    }
}
