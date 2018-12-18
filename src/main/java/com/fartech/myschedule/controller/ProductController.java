package com.fartech.myschedule.controller;

import com.fartech.myschedule.model.Product;
import com.fartech.myschedule.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/")
public class ProductController {
    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @CrossOrigin
    @GetMapping("/allProducts")
    public List<Product> getAllProducts() {
        System.out.println("All Products is called ...");
        return productRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
    }
    // Create a new Product
    @CrossOrigin
    @PostMapping("/addProduct")
    public Product addProduct(@Valid @RequestBody Product product) {
        System.out.println("Add Product is called ...");
        return productRepository.save(product);
    }
}
