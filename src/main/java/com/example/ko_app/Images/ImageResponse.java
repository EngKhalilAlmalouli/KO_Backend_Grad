package com.example.ko_app.Images;

public class ImageResponse {

    private Integer imageId;
    private String imageName;
    private String imagePath;
    private Integer productId;


    public ImageResponse(){}

    public ImageResponse(Integer imageId, String imageName, String imagePath, Integer productId) {
        this.imageId = imageId;
        this.imageName = imageName;
        this.imagePath = imagePath;
        this.productId = productId;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
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
        return "ImageResponse{" +
                "imageId=" + imageId +
                ", imageName='" + imageName + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", productId=" + productId +
                '}';
    }
}
