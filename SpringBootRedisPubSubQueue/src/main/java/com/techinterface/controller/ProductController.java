package com.techinterface.controller;


import com.techinterface.exception.SequenceException;
import com.techinterface.model.Product;
import com.techinterface.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


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

    @Autowired
    private CacheManager cacheManager;

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
     * @param id
     * @return String
     */
    @CacheEvict(value = "product", key = "#id")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable(value = "id") int id) {
        return productService.deleteProductByCode(id);
    }

    /**
     * Method to fetch user based on user id
     *
     * @param id
     * @return Product
     */
    @Cacheable(key="#id", value ="product")
    @GetMapping("findBy/{id}")
    public Optional<Product> findByCode(@PathVariable(value = "id") int id) {
        logger.info("ProductController: Fetching Product with id {}", id);
        return productService.findByCode(id);
    }

    @GetMapping("clear")
    public void clearCache(){
         for(String name:cacheManager.getCacheNames()){
             logger.info("Cache name is "+name+" Is cleared now . Data will be fetched from database now . ");
            cacheManager.getCache(name).clear();
        }
    }


}
