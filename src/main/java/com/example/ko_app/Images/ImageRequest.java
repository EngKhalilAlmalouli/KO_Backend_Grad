package com.example.ko_app.Images;

import jakarta.persistence.*;

public class ImageRequest {

    private String imageName;
    private String imagePath;
    private Integer productId;

    public ImageRequest(){}

    public ImageRequest(String imageName, String imagePath, Integer productId) {
        this.imageName = imageName;
        this.imagePath = imagePath;
        this.productId = productId;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "ImageRequest{" +
                "imageName='" + imageName + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", productId=" + productId +
                '}';
    }
}
