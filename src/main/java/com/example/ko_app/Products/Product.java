package com.example.ko_app.Products;

import com.example.ko_app.Categories.Category;
import com.example.ko_app.Images.Image;
import com.example.ko_app.Order.Order;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @SequenceGenerator(
            name = "product_id",
            sequenceName = "product_id",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_id")
    private Integer id;


    @Column(name = "product_name")
    private String product_name;

    @Column(name = "product_description")
    private String product_description;

    @Column(name = "product_price")
    private Double product_price;

    @Column(name = "product_quantity")
    private Integer product_quantity;

//    @Column(name = "product_image")
//    private String product_image;



    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id")
    private Image image;

    public Product() {
    }


    public Product(Integer id, String product_name, String product_description, Double product_price, Integer product_quantity, Category category, List<Order> orders, Image image) {
        this.id = id;
        this.product_name = product_name;
        this.product_description = product_description;
        this.product_price = product_price;
        this.product_quantity = product_quantity;
        this.category = category;
        this.orders = orders;
        this.image = image;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", product_name='" + product_name + '\'' +
                ", product_description='" + product_description + '\'' +
                ", product_price=" + product_price +
                ", product_quantity=" + product_quantity +
                ", category=" + category +
                ", orders=" + orders +
                ", image=" + image +
                '}';
    }
}