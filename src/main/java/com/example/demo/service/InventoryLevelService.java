package com.example.demo.service;
import java.util.List;
import com.example.demo.entity.Product;

public interface Product{
    public void createProduct(Product product);
    public Product getProductById(Long id);
    public List<Product> getAllProducts();
}