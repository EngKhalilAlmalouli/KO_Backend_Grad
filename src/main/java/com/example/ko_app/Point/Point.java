package com.example.ko_app.Point;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;
@Entity
public class Point {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer value;
    private Date createdAt;

    public Point() {}

    public Point(Integer id, String name, Integer value, Date createdAt) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.createdAt = createdAt;
    }

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

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Point{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", createdAt=" + createdAt +
                '}';
    }
}
