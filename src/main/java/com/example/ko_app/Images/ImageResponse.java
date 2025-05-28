package com.example.ko_app.Images;

public class ImageResponse {

    private Integer imageId;
    private String imageName;
    private String imagePath;
    private String imageType;
    private String imageImageData;
    private Integer productId;

    public ImageResponse() {}


    public ImageResponse(Integer imageId, String imageName, String imagePath, String imageType, String imageImageData, Integer productId) {
        this.imageId = imageId;
        this.imageName = imageName;
        this.imagePath = imagePath;
        this.imageType = imageType;
        this.imageImageData = imageImageData;
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
