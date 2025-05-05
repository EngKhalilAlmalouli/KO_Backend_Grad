package com.example.ko_app.Report;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;
@Entity
public class Report {
    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private String description;
    private String createdAt;
    private String updatedAt;

    public Report(){}
    public Report(Integer id, String title, String description, Date createdAt, Date updatedAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdAt = String.valueOf(createdAt);
        this.updatedAt = String.valueOf(updatedAt);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
