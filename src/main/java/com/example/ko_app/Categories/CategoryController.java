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

    @GetMapping
    public ResponseEntity<List<?>> getAllCategories() throws NotFoundInDatabaseException {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @GetMapping("/{id}")
    public CategoryResponse getCategoryById(@PathVariable Integer id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping
    public CategoryResponse createCategory(@RequestBody CategoryRequest request) {
        return categoryService.createCategory(request);
    }

    @PutMapping("/{id}")
    public CategoryResponse updateCategory(@PathVariable Integer id, @RequestBody CategoryRequest request) {
        return categoryService.updateCategory(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Integer id) throws NotFoundInDatabaseException {
        return categoryService.deleteCategory(id);
    }
}

