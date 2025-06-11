package com.example.ko_app.ImagesFile;

import com.example.ko_app.Products.Product;
import jakarta.persistence.*;
import lombok.*;
@Entity
public class ImageFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(
            name = "imagefile_id",
            sequenceName = "imagefile_id",
            allocationSize = 1
    )
    private Integer id;

    private String fileName;
    private String filePath;
    private String fileType;
    private Integer fileSize;


    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public ImageFile() {}

    public ImageFile(Integer id, java.lang.String fileName, java.lang.String filePath, java.lang.String fileType, Integer fileSize, Product product) {
        this.id = id;
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileType = fileType;
        this.fileSize = fileSize;
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public java.lang.String getFileName() {
        return fileName;
    }

    public void setFileName(java.lang.String fileName) {
        this.fileName = fileName;
    }

    public java.lang.String getFilePath() {
        return filePath;
    }

    public void setFilePath(java.lang.String filePath) {
        this.filePath = filePath;
    }

    public java.lang.String getFileType() {
        return fileType;
    }

    public void setFileType(java.lang.String fileType) {
        this.fileType = fileType;
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "ImageFile{" +
                "id=" + id +
                ", fileName=" + fileName +
                ", filePath=" + filePath +
                ", fileType=" + fileType +
                ", fileSize=" + fileSize +
                ", product=" + product +
                '}';
    }
}