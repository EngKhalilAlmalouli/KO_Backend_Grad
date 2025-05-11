package com.example.ko_app.Categories;

import com.example.ko_app.Configruration.NotFoundInDatabaseException;
import com.example.ko_app.validation.ObjectValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;
    private final ObjectValidator<CategoryRequest> validator;

    // Constructor for dependency injection
    public CategoryService(CategoryRepository categoryRepository, ObjectValidator<CategoryRequest> validator) {
        this.categoryRepository = categoryRepository;
        this.validator = validator;
    }

    public List<?> getAllCategories() {
        return categoryRepository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
    }
    // getCategoryById
    public CategoryResponse getCategoryById(Integer id) {
        return categoryRepository.findById(id)
                .map(this::mapToResponse)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    // createCategory
    public CategoryResponse createCategory(CategoryRequest request) {
        validator.validate(request);
        Category category = new Category();
        category.setCategoryName(request.getCategoryName());
        category.setCategoryDescription(request.getCategoryDescription());
        category = categoryRepository.save(category);
        return mapToResponse(category);

    }

    // updateCategory
    public CategoryResponse updateCategory(Integer id, CategoryRequest request) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        validator.validate(request);

        category.setCategoryName(request.getCategoryName());
        category.setCategoryDescription(request.getCategoryDescription());
        category = categoryRepository.save(category);
        return mapToResponse(category);
    }

    // deleteCategory
    public ResponseEntity<?> deleteCategory(Integer id) throws NotFoundInDatabaseException {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundInDatabaseException("Category not found"));

        categoryRepository.delete(category); // Ensure the customer is actually deleted
        return ResponseEntity.status(HttpStatus.OK).body("Category deleted successfully");
    }


    // mapToResponse
    private CategoryResponse mapToResponse(Category category) {
       // List<Integer> categoryIds = new ArrayList<>();
        CategoryResponse response = new CategoryResponse();
        response.setCategoryName(category.getCategoryName());
        response.setCategoryDescription(category.getCategoryDescription());
        response.setCategory_id(category.getId());
        return response;
    }
}
