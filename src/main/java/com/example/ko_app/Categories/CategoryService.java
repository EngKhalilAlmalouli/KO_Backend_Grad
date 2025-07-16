package com.example.ko_app.Categories;

import com.example.ko_app.Configruration.NotFoundInDatabaseException;
import com.example.ko_app.validation.ObjectValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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

    // Get all categories and map to CategoryResponse
    public List<CategoryResponse> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(this::mapToResponse) // Mapping Category -> CategoryResponse
                .collect(Collectors.toList());
    }

    // Get category by id and map to CategoryResponse
    public CategoryResponse getCategoryById(Integer id) {
        return categoryRepository.findById(id)
                .map(this::mapToResponse) // Mapping Category -> CategoryResponse
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    // Create category and return CategoryResponse
    public CategoryResponse createCategory(CategoryRequest request) {
        validator.validate(request);  // Validate request
        Category category = new Category();
        category.setCategoryName(request.getCategoryName());
        category.setCategoryDescription(request.getCategoryDescription());
        category = categoryRepository.save(category);
        return mapToResponse(category);
    }

    // Update category and return CategoryResponse
    public CategoryResponse updateCategory(Integer id, CategoryRequest request) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        validator.validate(request);

        category.setCategoryName(request.getCategoryName());
        category.setCategoryDescription(request.getCategoryDescription());
        category = categoryRepository.save(category);
        return mapToResponse(category);
    }

    // Delete category and return response
    public ResponseEntity<?> deleteCategory(Integer id) throws NotFoundInDatabaseException {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundInDatabaseException("Category not found"));

        categoryRepository.delete(category);
        return ResponseEntity.status(HttpStatus.OK).body("Category deleted successfully");
    }

    // Mapping method for Category to CategoryResponse
    private CategoryResponse mapToResponse(Category category) {
        CategoryResponse response = new CategoryResponse();
        response.setCategory_id(category.getId());  // Map category ID to response
        response.setCategoryName(category.getCategoryName());  // Map category name
        response.setCategoryDescription(category.getCategoryDescription());  // Map category description
        return response;
    }
}
