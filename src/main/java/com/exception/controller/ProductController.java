package com.exception.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exception.dto.ProductDto;
import com.exception.entities.Category;
import com.exception.entities.Product;
import com.exception.repositories.ProductRepo;
import com.exception.service.CartItemService;
import com.exception.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins="*")
public class ProductController {
	@Autowired
    private ProductRepo productRepository;

    @Autowired
    private ProductService productservice;
  
    
    
    

 // Get all products
    @GetMapping("al")
    public ResponseEntity<List<Product>> getAllProducts() {
        // Retrieve and return all products
        List<Product> products = productRepository.findAll();
        return ResponseEntity.ok(products);
    }

    // Get product by ID
    @GetMapping("/getproduct/{productId}")
    public ResponseEntity<Product> getCategoryById(@PathVariable Long productId) {
        // Retrieve and return product by ID
        Product product = productservice.getProductById(productId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    // Search products based on a query
    @GetMapping("/search/{query}")
    public ResponseEntity<List<Product>> searchProducts(@PathVariable String query) {
        // Retrieve and return products matching the search query
        List<Product> searchResults = productservice.searchProducts(query);
        return ResponseEntity.ok(searchResults);
    }

    // Create a new product
    @PostMapping("/addproduct")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        // Save and return the created product
        Product savedProduct = productservice.saveProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

}
