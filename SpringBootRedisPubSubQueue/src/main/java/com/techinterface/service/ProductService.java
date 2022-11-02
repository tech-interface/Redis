package com.techinterface.service;

import com.techinterface.model.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ProductService {


    ResponseEntity<String> deleteProductByCode(int id);

    ResponseEntity<Product> findProductByCode(String code);

    ResponseEntity<Product> addProduct(Product product);

    List<Product> getAllProducts();

    Optional<Product> findByCode(int code);


}
