package com.example.demo.service;
import java.util.List;
import com.example.demo.entity.Product;

public interface Product{
     Product createProduct(Product product);
     Product getProductById(Long id);
     List<Product> getAllProducts();
}