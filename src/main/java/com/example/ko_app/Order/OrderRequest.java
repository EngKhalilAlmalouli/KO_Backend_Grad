package com.example.ko_app.Order;

import java.util.Date;

public class OrderRequest {
    private Integer orderQuantity;
    private Double orderSubTotal;
    private Double orderTotal;
    private String orderStatus;
    private Double orderTotalPrice;
    private String orderShippingAddress;
    private Date orderCreateAt;
    private Date orderUpdateAt;
    private Integer customerId; // لربط الطلب بالزبون
    private Integer productId;


    public OrderRequest() {}

    public OrderRequest(Integer orderQuantity, Double orderSubTotal, Double orderTotal, String orderStatus, Double orderTotalPrice, String orderShippingAddress, Date orderCreateAt, Date orderUpdateAt, Integer customerId, Integer productId) {
        this.orderQuantity = orderQuantity;
        this.orderSubTotal = orderSubTotal;
        this.orderTotal = orderTotal;
        this.orderStatus = orderStatus;
        this.orderTotalPrice = orderTotalPrice;
        this.orderShippingAddress = orderShippingAddress;
        this.orderCreateAt = orderCreateAt;
        this.orderUpdateAt = orderUpdateAt;
        this.customerId = customerId;
        this.productId = productId;
    }

    public Integer getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(Integer orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public Double getOrderSubTotal() {
        return orderSubTotal;
    }

    public void setOrderSubTotal(Double orderSubTotal) {
        this.orderSubTotal = orderSubTotal;
    }

    public Double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(Double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Double getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(Double orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    public String getOrderShippingAddress() {
        return orderShippingAddress;
    }

    public void setOrderShippingAddress(String orderShippingAddress) {
        this.orderShippingAddress = orderShippingAddress;
    }

    public Date getOrderCreateAt() {
        return orderCreateAt;
    }

    public void setOrderCreateAt(Date orderCreateAt) {
        this.orderCreateAt = orderCreateAt;
    }

    public Date getOrderUpdateAt() {
        return orderUpdateAt;
    }

    public void setOrderUpdateAt(Date orderUpdateAt) {
        this.orderUpdateAt = orderUpdateAt;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "orderQuantity=" + orderQuantity +
                ", orderSubTotal=" + orderSubTotal +
                ", orderTotal=" + orderTotal +
                ", orderStatus='" + orderStatus + '\'' +
                ", orderTotalPrice=" + orderTotalPrice +
                ", orderShippingAddress='" + orderShippingAddress + '\'' +
                ", orderCreateAt=" + orderCreateAt +
                ", orderUpdateAt=" + orderUpdateAt +
                ", customerId=" + customerId +
                ", productId=" + productId +
                '}';
    }
}
