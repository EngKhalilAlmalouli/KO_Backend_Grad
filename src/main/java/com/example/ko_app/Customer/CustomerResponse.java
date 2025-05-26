//package com.example.KO_Recycle_App.Customer;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
//public class CustomerResponse {
//    private Integer customerId;
//    private String username;
//    private String firstName;
//    private String lastName;
//    private String email;
//    private String password;
//    private String phoneNumber;
//    private String address;
//    private String image;
//
//}

package com.example.ko_app.Customer;

import com.example.ko_app.Order.Order;
import com.example.ko_app.Order.OrderResponse;

import java.util.List;

public class CustomerResponse {
    private Integer customerId;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
    private String image;
    private List<Order> orders;

    // Default constructor
    public CustomerResponse() {
    }

    public CustomerResponse(Integer customerId, String username, String firstName, String lastName, String email, String password, String phoneNumber, String address, String image, List<Order> orders) {
        this.customerId = customerId;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.image = image;
        this.orders = orders;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "CustomerResponse{" +
                "customerId=" + customerId +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", image='" + image + '\'' +
                ", orders=" + orders +
                '}';
    }
}


