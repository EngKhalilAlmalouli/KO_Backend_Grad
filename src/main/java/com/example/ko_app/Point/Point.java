package com.example.ko_app.Point;

import com.example.ko_app.Customer.Customer;
import jakarta.persistence.*;

import java.util.Date;
@Entity
public class Point {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer value;
    private String createdAt;



    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Point() {}

    public Point(Integer id, String name, Integer value, String createdAt, Customer customer) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.createdAt = createdAt;
        this.customer = customer;
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Point{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", createdAt='" + createdAt + '\'' +
                ", customer=" + customer +
                '}';
    }
}
