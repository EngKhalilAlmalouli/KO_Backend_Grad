package com.example.ko_app.Images;

import com.example.ko_app.Customer.Customer;
import com.example.ko_app.Products.Product;
import jakarta.persistence.*;

@Entity
@Table(name = "image")
public class Image {
    @Id
    @SequenceGenerator(
            name = "image_id",
            sequenceName = "image_id",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "image_id")
    private Integer id;

    @Column(name = "image_name")

    private String name;
    @Column(name = "image_path")
    private String path;


    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Image() {}

    public Image(Integer id, String name, String path, Product product) {
        this.id = id;
        this.name = name;
        this.path = path;
        this.product = product;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", product=" + product +
                '}';
    }
}
