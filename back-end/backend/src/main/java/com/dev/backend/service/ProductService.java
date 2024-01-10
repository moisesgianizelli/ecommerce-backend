package com.dev.backend.service;

import com.dev.backend.entity.Product;
import com.dev.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public List<Product> searchAll(){
        return productRepository.findAll();
    }

    public Product insert(Product product){
        product.setDateCreation(new Date());
        Product newProduct = productRepository.saveAndFlush(product);
        return newProduct;
    }

    public Product modify(Product product){
        product.setDateUpdate(new Date());
        return productRepository.saveAndFlush(product);
    }

    public void delete(Long id){
        Product product = productRepository.findById(id).get();
        productRepository.delete(product);
    }
}
