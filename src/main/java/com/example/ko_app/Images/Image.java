package com.example.ko_app.Images;

import com.example.ko_app.Products.Product;
import jakarta.persistence.*;

@Entity
@Table(name = "ImageData")
public class Image {

    @Id
    @SequenceGenerator(
            name = "image_id",
            sequenceName = "image_id",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "image_id")
    private Integer id;

    private String name;
    private String type;

    @Lob
    @Column(name = "imagedata", length = 1000)
    private byte[] imageData;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    // Constructors
    public Image() {
    }

    public Image(Integer id, String name, String type, byte[] imageData, Product product) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.imageData = imageData;
        this.product = product;
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

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
