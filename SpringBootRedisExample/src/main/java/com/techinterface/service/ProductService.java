package com.techinterface.service;

import com.techinterface.model.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {


    ResponseEntity<String> deleteProductByCode(String code);

    ResponseEntity<Product> findProductByCode(String code);

    ResponseEntity<Product> addProduct(Product product);

    List<Product> getAllProducts();



}
