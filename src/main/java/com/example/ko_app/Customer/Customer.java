package com.example.ko_app.Customer;

import com.example.ko_app.Order.Order;
import com.example.ko_app.Order.OrderResponse;
import com.example.ko_app.Point.Point;
import com.example.ko_app.Report.Report;
import com.example.ko_app.Review.Review;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @SequenceGenerator(
            name = "customer_id",
            sequenceName = "customer_id",
            allocationSize = 1

    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id")
    private Integer id;

    @Column(name = "customer_firstName")
    private String firstName;

    @Column(name = "customer_lastName")
    private String lastName;

    @Column(name = "customer_userName")
    private String userName;

    @Column(name = "customer_address")
    private String address;

    @Column(name = "customer_phone")
    private String phone;

    @Column(name = "customer_email")
    private String email;

    @Column(name = "customer_password")
    private String password;

    @Column(name = "customer_image")
    private String image;


    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Point> points = new ArrayList<>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Report> reports = new ArrayList<>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();


    public Customer() {
    }

    public Customer(Integer id, String firstName, String lastName, String userName, String address, String phone, String email, String password, String image, List<Point> points, List<Report> reports, List<Review> reviews) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.image = image;
        this.points = points;
        this.reports = reports;
        this.reviews = reviews;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", image='" + image + '\'' +
                ", points=" + points +
                ", reports=" + reports +
                ", reviews=" + reviews +
                '}';
    }
}

