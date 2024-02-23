package com.exception.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.entities.Category;
import com.exception.entities.Product;
import com.exception.exceptions.NotFoundException;
import com.exception.exceptions.ProductNotFoundException;
import com.exception.repositories.ProductRepo;

import jakarta.el.MethodNotFoundException;

@Service
public class ProductService {
	@Autowired
    private ProductRepo productRepository;
	
	@Autowired
	private CategoryService categoryService;
	
	
	//Method used for adding the product to category
public Product addProductToCategory(long categoryId, Product product) {
		
		Category category = categoryService.getCategoryById(categoryId);

        // Associate the product with the category
        product.setCategory(category);

        // Save and return the created product
        return saveProduct(product);
		// TODO Auto-generated method stub
		
	}
	
//Method used to save the product
    public Product saveProduct(Product product) {
    	try {
        return productRepository.save(product);
    	}catch(Exception e) {
			
	        throw new ProductNotFoundException("Error while saving product");
		}
    }
    
//Method used to get list of products
    public List<Product> getAllProducts() {
    	try {
        return productRepository.findAll();
    	}catch(Exception e) {
		
	        throw new ProductNotFoundException("Error while getting products");
		}
    }
    
    //Method used to get product image based on its id
    public String getProductImageById(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + productId));

        if(product!=null) {
        return product.getImageUrl();
        }
        else {
        	throw new ProductNotFoundException("Error while getting  product");
        }
    }

    
    //Method used to get Product by Id
	public Product getProductById(Long productId) {
		
		Product product =productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + productId));
		if(product!=null) {
	return product;
		}
		else{
			
	        throw new ProductNotFoundException("Error while getting  product");
		}
	}


//Method used to search list of products by its name
	 public List<Product> searchProducts(String query) {
		 try {
	        return productRepository.findByNameContainingIgnoreCase(query);
		 }
		 catch(Exception e) {
				
		        throw new ProductNotFoundException("Error while searching  product");
			}
	    }

	
		 
		
	}



