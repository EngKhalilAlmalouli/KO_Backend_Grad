package com.example.ko_app.Order;

import com.example.ko_app.Customer.Customer;
import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "\"order\"")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer quantity;
    private Double subTotal;
    private Double total;
    private String status;
    private Double totalPrice;
    private String shippingAddress;
    private Date createAt;
    private Date updateAt;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


    public Order() {}

    public Order(Integer id, Integer quantity, Double subTotal, Double total, String status, Double totalPrice, String shippingAddress, Date createAt, Date updateAt, Customer customer) {
        this.id = id;
        this.quantity = quantity;
        this.subTotal = subTotal;
        this.total = total;
        this.status = status;
        this.totalPrice = totalPrice;
        this.shippingAddress = shippingAddress;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.customer = customer;
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

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", subTotal=" + subTotal +
                ", total=" + total +
                ", status='" + status + '\'' +
                ", totalPrice=" + totalPrice +
                ", shippingAddress='" + shippingAddress + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", customer=" + customer +
                '}';
    }
}
