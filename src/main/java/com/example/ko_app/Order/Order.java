package com.example.ko_app.Order;

import com.example.ko_app.Customer.Customer;
import com.example.ko_app.Products.Product;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @SequenceGenerator(
            name = "order_id",
            sequenceName = "order_id",
            allocationSize = 1

    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_id")
    private Integer id;

    @Column(name = "order_quantity")
    private Integer quantity;

    @Column(name = "order_shippingAddress")
    private String shippingAddress;


    @ManyToMany
    @JoinTable(
            name = "order_products", // اسم الجدول الوسيط
            joinColumns = @JoinColumn(name = "order_id"), // مفتاح الربط من جهة Order
            inverseJoinColumns = @JoinColumn(name = "product_id") // مفتاح الربط من جهة Product
    )
    private List<Product> products = new ArrayList<>();


    public Order() {
    }

    public Order(Integer id, Integer quantity, String shippingAddress, List<Product> products) {
        this.id = id;
        this.quantity = quantity;
        this.shippingAddress = shippingAddress;
        this.products = products;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", shippingAddress='" + shippingAddress + '\'' +
                ", products=" + products +
                '}';
    }
}
