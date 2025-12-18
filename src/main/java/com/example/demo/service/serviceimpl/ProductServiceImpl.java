package com.example.demo.service.serviceimpl;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productrepo;

    public ProductServiceImpl(ProductRepository productrepo){
        this.productrepo = productrepo;
    }

    @Override
    public Product createProduct(Product product){
        if(productrepo.exitsBySku(product.getSku())){
            throw new RuntimeException("SKU already exists");
        }
        return productrepo.save(product);
    }

    @Override
    public Product getProductById(Long id){
        return productrepo.findById(id).orElseThrow(()->new RuntimeException("not found"));
    }

    @Override
    public 
}