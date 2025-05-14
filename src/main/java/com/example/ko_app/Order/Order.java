package com.example.ko_app.Order;

import com.example.ko_app.Customer.Customer;
import com.example.ko_app.Products.Product;
import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @SequenceGenerator(
            name = "order_id",
            sequenceName = "order_id",
            allocationSize = 1

    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "order_id")
    private Integer id;

    @Column(name = "order_quantity")
    private Integer quantity;

    @Column(name = "order_subTotal")
    private Double subTotal;

    @Column(name = "order_total")
    private Double total;

    @Column(name = "order_status")
    private String status;

    @Column(name = "order_totalPrice")
    private Double totalPrice;

    @Column(name = "order_shippingAddress")
    private String shippingAddress;

    @Column(name = "order_createAt")
    private Date createAt;

    @Column(name = "order_updateAt")
    private Date updateAt;



    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Order() {}

    public Order(Integer id, Integer quantity, Double subTotal, Double total, String status, Double totalPrice, String shippingAddress, Date createAt, Date updateAt, Customer customer, Product product) {
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
        this.product = product;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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
                ", product=" + product +
                '}';
    }
}
