package com.example.ko_app.Products;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private Integer id;
    private String product_name;
    private String product_description;
    private Double product_price;
    private Integer product_quantity;
    private String product_image;


    public Product() {
    }

    public Product(Integer id, String product_name, String product_description, Double product_price, Integer product_quantity, String product_image) {
        this.id = id;
        this.product_name = product_name;
        this.product_description = product_description;
        this.product_price = product_price;
        this.product_quantity = product_quantity;
        this.product_image = product_image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public Double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(Double product_price) {
        this.product_price = product_price;
    }

    public Integer getProduct_quantity() {
        return product_quantity;
    }

    public void setProduct_quantity(Integer product_quantity) {
        this.product_quantity = product_quantity;
    }

    public String getProduct_image() {
        return product_image;
    }

    public void setProduct_image(String product_image) {
        this.product_image = product_image;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", product_name='" + product_name + '\'' +
                ", product_description='" + product_description + '\'' +
                ", product_price=" + product_price +
                ", product_quantity=" + product_quantity +
                ", product_image='" + product_image + '\'' +
                '}';
    }

}