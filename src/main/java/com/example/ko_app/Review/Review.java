package com.example.ko_app.Review;

import com.example.ko_app.Customer.Customer;
import jakarta.persistence.*;

@Entity
@Table(name = "review")
public class Review {
    @Id
    @SequenceGenerator(
            name = "review_id",
            sequenceName = "review_id",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "review_id")
    private Integer id;

    @Column(name = "review_title")
    private String title;

    @Column(name = "review_description")
    private String description;


    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


    public Review() {}

    public Review(Integer id, String title, String description, Customer customer) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.customer = customer;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", customer=" + customer +
                '}';
    }
}
