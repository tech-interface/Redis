package com.techinterface.service.impl;

import com.techinterface.exception.ResourceNotFoundException;

import com.techinterface.model.Product;
import com.techinterface.repository.ProductRepository;
import com.techinterface.service.ProductService;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    /* autowired dependencies */
    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }




    @SneakyThrows
    @Override
    public ResponseEntity<Product> addProduct(Product product) {
        if (product.getName().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

            productRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @Override
    public ResponseEntity<Product> findProductByCode(String code) {
        Optional<Product> movie = Optional.ofNullable(productRepository.findProductByCode(code)
                .orElseThrow(() -> new ResourceNotFoundException("Product with ID :" + code + " Not Found!")));
        if (movie.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(movie.get());
    }

    @Override
    public ResponseEntity<String> deleteProductByCode(String code) {
        productRepository.deleteProductByCode(code);
        return ResponseEntity.ok("Product deleted successfully ");
    }








}
