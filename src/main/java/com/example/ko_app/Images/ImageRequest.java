package com.example.ko_app.Images;

import jakarta.persistence.*;

public class ImageRequest {

    private String imageName;
    private String imagePath;
    private String imageType;
    private String imageImageData;
    private Integer productId;


    public ImageRequest() {}
    public ImageRequest(String imageName, String imagePath, String imageType, String imageImageData, Integer productId) {
        this.imageName = imageName;
        this.imagePath = imagePath;
        this.imageType = imageType;
        this.imageImageData = imageImageData;
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

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public String getImageImageData() {
        return imageImageData;
    }

    public void setImageImageData(String imageImageData) {
        this.imageImageData = imageImageData;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
