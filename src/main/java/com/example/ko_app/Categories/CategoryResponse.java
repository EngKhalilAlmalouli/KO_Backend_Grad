package com.example.ko_app.Categories;

public class CategoryResponse {

    private Integer category_id;
    private String categoryName;
    private String categoryDescription;

    public CategoryResponse() {}
    public CategoryResponse(Integer category_id, String categoryName, String categoryDescription) {
        this.category_id = category_id;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    @Override
    public String toString() {
        return "CategoryResponse{" +
                "category_id=" + category_id +
                ", categoryName='" + categoryName + '\'' +
                ", categoryDescription='" + categoryDescription + '\'' +
                '}';
    }
}
