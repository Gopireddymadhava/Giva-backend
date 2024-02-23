package com.exception.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exception.dto.CategoryDto;
import com.exception.entities.Category;
import com.exception.entities.Product;
import com.exception.service.CategoryService;
import com.exception.service.ProductService;

@RestController
@CrossOrigin(origins = "*")
public class CategoryController {
	@Autowired
    private CategoryService categoryService;
	
	@Autowired
	private ProductService productservice;



	// Get category by ID
	@GetMapping("/get/{categoryId}")
	public ResponseEntity<Category> getCategoryById(@PathVariable Long categoryId) {
	    // Retrieve category by ID
	    Category category = categoryService.getCategoryById(categoryId);
	    return new ResponseEntity<>(category, HttpStatus.OK);
	}

	// Create a new category
	@PostMapping("/createcat")
	public ResponseEntity<CategoryDto> createCategory(@RequestBody Category category) {
	    // Save and return the created category
	    CategoryDto savedCategory = categoryService.saveCategory(category);
	    return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
	}

	// Get products by category ID
	@GetMapping("/{categoryId}/products")
	public ResponseEntity<List<Product>> getProductsByCategoryId(@PathVariable long categoryId) {
	    // Retrieve products associated with the given category ID
	    List<Product> products = categoryService.getProductsByCategoryId(categoryId);
	    return new ResponseEntity<>(products, HttpStatus.OK);
	}

	// Add a product to a category
	@PostMapping("/{categoryId}/products")
	public ResponseEntity<Product> addProductToCategory(
	        @PathVariable long categoryId,
	        @RequestBody Product product) {
	   
	    // Save and return the created product
		Product savedProduct = productservice.addProductToCategory(categoryId, product);
	    return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
	}



}
