package com.example.ko_app.Order;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;
@Entity
public class Order {

    @Id
    @GeneratedValue
    private Integer id;
    //    private Integer customerId;
//    private Integer productId;
    private Integer quantity;
    private Double subTotal;
    private Double total;
    private String status;
    private Double totalPrice;
    private String shippingAddress;
    private Date createAt;
    private Date updateAt;

    public Order() {}

    public Order(Integer id, Integer quantity, Double subTotal, Double total, String status, Double totalPrice, String shippingAddress, Date createAt, Date updateAt) {
        this.id = id;
        this.quantity = quantity;
        this.subTotal = subTotal;
        this.total = total;
        this.status = status;
        this.totalPrice = totalPrice;
        this.shippingAddress = shippingAddress;
        this.createAt = createAt;
        this.updateAt = updateAt;
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
                '}';
    }
}
