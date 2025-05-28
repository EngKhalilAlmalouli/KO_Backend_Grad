package com.example.ko_app.File;

import jakarta.persistence.*;

@Entity
@Table(name = "FILE_DATA")
public class FileData {

    @Id
    @SequenceGenerator(
            name = "filedata_seq",
            sequenceName = "filedata_seq",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "filedata_seq")
    private Integer id;

    private String name;

    private String type;

    private String filePath;

    // No-args constructor
    public FileData() {
    }

    // All-args constructor
    public FileData(Integer id, String name, String type, String filePath) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.filePath = filePath;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    // Optional: toString for debugging
    @Override
    public String toString() {
        return "FileData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}
