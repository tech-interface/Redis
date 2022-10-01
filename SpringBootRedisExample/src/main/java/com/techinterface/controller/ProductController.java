package com.techinterface.controller;


import com.techinterface.exception.SequenceException;
import com.techinterface.model.Product;
import com.techinterface.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


/**
 * Rest Api implementations for User
 * CRUD operations for domain
 *
 * @author tech-interface
 * @version 0.1
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    /**
     * Method to fetch all movies
     *
     * @return list of movies
     */
    @GetMapping("/all")
    public List<Product> getAllProducts() {
        logger.info("ProductController-> getAllProducts ");
        return productService.getAllProducts();
    }


    /**
     * Method to create user
     *
     * @param product
     * @return Product
     * @throws SequenceException
     */
    @PostMapping("/add")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) throws SequenceException {
        return productService.addProduct(product);
    }

    /**
     * Method to fetch user based on user id
     *
     * @param code
     * @return Product
     */
    @GetMapping("fetch/{code}")
    public ResponseEntity<Product> findProduct(@PathVariable(value = "code") String code) {
        logger.info("ProductController: Fetching Product with id {}", code);
        return productService.findProductByCode(code);
    }


    /**
     * Method to delete movie
     *
     * @param code
     * @return String
     */
    @DeleteMapping("/delete/{mId}")
    public ResponseEntity<String> deleteProduct(@PathVariable(value = "code") String code) {
        return productService.deleteProductByCode(code);
    }


}
