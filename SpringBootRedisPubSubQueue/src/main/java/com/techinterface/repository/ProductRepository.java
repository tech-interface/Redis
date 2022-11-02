package com.techinterface.repository;


import com.techinterface.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Product, String> {
    Optional<Product> findProductByCode(String code);
    void deleteProductByCode(String code);

}
