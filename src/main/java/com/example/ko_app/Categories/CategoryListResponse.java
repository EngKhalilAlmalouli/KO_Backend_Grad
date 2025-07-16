package com.example.ko_app.Categories;

import java.util.List;

public class CategoryListResponse {

    private List<CategoryResponse> categories;

    // Constructor
    public CategoryListResponse(List<CategoryResponse> categories) {
        this.categories = categories;
    }

    // Getter
    public List<CategoryResponse> getCategories() {
        return categories;
    }

    // Setter
    public void setCategories(List<CategoryResponse> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "CategoryListResponse{" +
                "categories=" + categories +
                '}';
    }
}
