package com.exception.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.dto.CategoryDto;
import com.exception.entities.Category;
import com.exception.entities.Product;
import com.exception.exceptions.CategoryNotFoundException;
import com.exception.exceptions.NotFoundException;
import com.exception.mapper.CategoryMapper;
import com.exception.repositories.CategoryRepo;

@Service
public class CategoryService {
	
@Autowired
private CategoryRepo categoryRepository;

@Autowired
private ProductService productser;

@Autowired
private CategoryMapper categorymapper;

//Method used to get list of Categories
public List<Category> getAllCategories() {
    try {
        return categoryRepository.findAll();
    } catch (Exception e) {
      
        throw new CategoryNotFoundException("Error while retrieving all categories");
    }
}

//Method used to get category Based on categoryId
public Category getCategoryById(long categoryId) {
    try {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found with id: " + categoryId));
    } catch (Exception e) {
      
        throw new CategoryNotFoundException("Error while getting category by ID");
    }
}

//Method used to save the category
public CategoryDto saveCategory(Category category) {
    try {
        return categorymapper.toCategoryDto(categoryRepository.save(category));
    } catch (Exception e) {
     
        throw new CategoryNotFoundException("Error while saving category");
    }
}

//Method used to delete the category
public void deleteCategory(long categoryId) {
    try {
        categoryRepository.deleteById(categoryId);
    } catch (Exception e) {
      
        throw new CategoryNotFoundException("Error while deleting category");
    }
}

//Method used to get list of products based on category  id
public List<Product> getProductsByCategoryId(long categoryId) {
    try {
        Category category = getCategoryById(categoryId);
        return category.getProducts();
    } catch (Exception e) {
     
        throw new CategoryNotFoundException("Error while getting products by category ID");
    }
}

}
