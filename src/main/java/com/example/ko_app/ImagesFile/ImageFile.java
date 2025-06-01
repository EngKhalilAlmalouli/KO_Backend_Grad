package com.example.ko_app.ImagesFile;

import com.example.ko_app.Products.Product;
import jakarta.persistence.*;
import lombok.*;
@Entity
public class ImageFile {

    @Id
    @SequenceGenerator(
            name = "imagefile_id",
            sequenceName = "imagefile_id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "imagefile_id"
    )
    private Integer id;

    private String fileName;
    private String filePath;
    private String fileType;
    private Integer fileSize;

    @Enumerated(EnumType.STRING)
    private ResourceType relationType;

    private Integer relationId;


    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    // Constructors
    public ImageFile() {
    }

    public ImageFile(Integer id, String fileName, String filePath, String fileType, Integer fileSize, ResourceType relationType, Integer relationId) {
        this.id = id;
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileType = fileType;
        this.fileSize = fileSize;
        this.relationType = relationType;
        this.relationId = relationId;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    public ResourceType getRelationType() {
        return relationType;
    }

    public void setRelationType(ResourceType relationType) {
        this.relationType = relationType;
    }

    public Integer getRelationId() {
        return relationId;
    }

    public void setRelationId(Integer relationId) {
        this.relationId = relationId;
    }

    @Override
    public String toString() {
        return "ImageFile{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", fileType='" + fileType + '\'' +
                ", fileSize=" + fileSize +
                ", relationType=" + relationType +
                ", relationId=" + relationId +
                '}';
    }
}