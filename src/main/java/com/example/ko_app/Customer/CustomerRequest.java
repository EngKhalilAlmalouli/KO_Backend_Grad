package com.example.ko_app.Customer;//package com.example.KO_Recycle_App.Customer;
//
//import jakarta.validation.constraints.*;
//import lombok.Data;
//
//@Data
//public class CustomerRequest {
//    @NotNull(message = "username should not be null")
//    @NotEmpty(message = "username should not be null")
//    @NotBlank(message = "Please provide a username")
//    private String userName;
//    @NotNull(message = "firstName should not be null")
//    @NotEmpty(message = "firstName should not be null")
//    @NotBlank(message = "Please provide a firstName")
//    private String firstName;
//    @NotNull(message = "lastName should not be null")
//    @NotEmpty(message = "lastName should not be null")
//    @NotBlank(message = "Please provide a lastName")
//    private String lastName;
//    @NotNull(message = "address should not be null")
//    @NotEmpty(message = "address should not be null")
//    @NotBlank(message = "Please provide a address")
//    private String address;
//    @NotNull(message = "phone should not be null")
//    @NotEmpty(message = "phone should not be null")
//    @NotBlank(message = "Please provide a phone")
//    private String phone;
//    @NotNull(message = "email should not be null")
//    @NotEmpty(message = "email should not be null")
//    @Email(message = "Please provide a email")
//    private String email;
//    @NotNull(message = "password should not be null")
//    @NotEmpty(message = "password should not be null")
//    @Email(message = "Please provide a password")
//    private String password;
//    @NotNull(message = "image should not be null")
//    @NotEmpty(message = "image should not be null")
//    @Email(message = "Please provide a image")
//    private String image;
//}


import com.example.ko_app.Order.Order;
import com.example.ko_app.Order.OrderResponse;

import java.util.List;

public class CustomerRequest {
    private String firstName;
    private String lastName;
    private String userName;
    private String address;
    private String phone;
    private String email;
    private String password;
    private String image;



    public CustomerRequest(){}

    public CustomerRequest(String firstName, String lastName, String userName, String address, String phone, String email, String password, String image) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.image = image;
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

    @Override
    public String toString() {
        return "CustomerRequest{" +
                "firstName='" + firstName + '\'' +
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
