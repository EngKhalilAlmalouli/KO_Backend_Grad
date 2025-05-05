package com.example.ko_app.Customer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

//package com.example.KO_Recycle_App.Customer;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.Id;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class Customer {
//    @Id
//    @GeneratedValue
//    private Integer id;
//    private String userName;
//    private String firstName;
//    private String lastName;
//    private String address;
//    private String phone;
//    private String email;
//    private String password;
//    private String image;
//
//
//
//}
@Entity
public class Customer {
    @Id
    @GeneratedValue
    private Integer id;
    private String firstName;
    private String lastName;
    private String userName;
    private String address;
    private String phone;
    private String email;
    private String password;
    private String image;

    public Customer() {}

    public Customer(String firstName, String lastName, String userName, String address, String phone, String email, String password, String image) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.image = image;
    }
    // Getter and Setter methods for each field
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
                '}';
    }
}

