package com.example.ko_app.Categories;

import com.example.ko_app.Configruration.NotFoundInDatabaseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    // Constructor for dependency injection
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // Fetch all categories and wrap them in CategoryListResponse
    @GetMapping
    public ResponseEntity<CategoryListResponse> getAllCategories() throws NotFoundInDatabaseException {
        List<CategoryResponse> categoryResponseList = categoryService.getAllCategories();

        // Wrap the list inside CategoryListResponse and return
        CategoryListResponse categoryListResponse = new CategoryListResponse(categoryResponseList);
        return ResponseEntity.ok(categoryListResponse);
    }

    // Get a specific category by id
    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getCategoryById(@PathVariable Integer id) {
        CategoryResponse categoryResponse = categoryService.getCategoryById(id);
        return ResponseEntity.ok(categoryResponse);
    }

    // Create a new category
    @PostMapping
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody CategoryRequest request) {
        CategoryResponse categoryResponse = categoryService.createCategory(request);
        return ResponseEntity.status(201).body(categoryResponse);  // Return with status 201 Created
    }

    // Update an existing category
    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> updateCategory(@PathVariable Integer id, @RequestBody CategoryRequest request) {
        CategoryResponse categoryResponse = categoryService.updateCategory(id, request);
        return ResponseEntity.ok(categoryResponse);
    }

    // Delete a category by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Integer id) throws NotFoundInDatabaseException {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();  // No content status for successful deletion
    }
}
