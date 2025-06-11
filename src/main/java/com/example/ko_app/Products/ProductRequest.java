package com.example.ko_app.Products;

public class ProductRequest {
    private String productName;
    private String productDescription;
    private Double productPrice;
    private Integer productQuantity;
//    private String productImage;
    private Integer categoryId;
//    private Integer imageId;


    public ProductRequest() {}

    public ProductRequest(String productName, String productDescription, Double productPrice, Integer productQuantity, Integer categoryId, Integer imageId) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.categoryId = categoryId;
//        this.imageId = imageId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

//    public Integer getImageId() {
//        return imageId;
//    }

//    public void setImageId(Integer imageId) {
//        this.imageId = imageId;
//    }

    @Override
    public String toString() {
        return "ProductRequest{" +
                "productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productPrice=" + productPrice +
                ", productQuantity=" + productQuantity +
                ", categoryId=" + categoryId +
//                ", imageId=" + imageId +
                '}';
    }
}
