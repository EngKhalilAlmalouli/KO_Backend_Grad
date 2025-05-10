package com.example.ko_app.Task;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Task {
    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private String description;
    private String date;
    private String note;
    private String status;

    public Task() {
    }

    public Task(Integer id, String title, String description, String date, String note, String status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.note = note;
        this.status = status;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                ", note='" + note + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
