package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public Product createProduct(Product p) {
        return repo.save(p);
    }

    public Product getProductById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    public void deactivateProduct(Long id) {
        Product p = getProductById(id);
        p.setActive(false);
        repo.save(p);
    }

    public List<Product> getAll() {
        return repo.findAll();
    }
}
