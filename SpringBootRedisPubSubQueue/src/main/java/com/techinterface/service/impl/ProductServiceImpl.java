package com.techinterface.service.impl;

import com.techinterface.exception.ResourceNotFoundException;

import com.techinterface.model.Product;
import com.techinterface.repository.ProductRepository;
import com.techinterface.service.ProductService;

import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    /* autowired dependencies */
    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    @Override

    public Optional<Product> findByCode(int id) {
        Optional<Product> product = Optional.ofNullable(productRepository.findById(String.valueOf(id))
                .orElseThrow(() -> new ResourceNotFoundException("Product with ID :" + id + " Not Found!")));
        if (product.isEmpty()) {
            return product;
        }

        logger.info("#### Data is returned form database ");
        return product;
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
        Optional<Product> product = Optional.ofNullable(productRepository.findProductByCode(code)
                .orElseThrow(() -> new ResourceNotFoundException("Product with ID :" + code + " Not Found!")));
        if (product.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }


        return ResponseEntity.ok(product.get());
    }

    @Override
    public ResponseEntity<String> deleteProductByCode(int id) {
        productRepository.deleteById(String.valueOf(id));
        return ResponseEntity.ok("Product deleted successfully ");
    }








}
