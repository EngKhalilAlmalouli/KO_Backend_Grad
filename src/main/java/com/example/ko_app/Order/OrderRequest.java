package com.example.ko_app.Order;

import java.util.Date;

public class OrderRequest {
    private Integer orderQuantity;

    private String orderShippingAddress;

    private Integer productId;


    public OrderRequest() {}

    public OrderRequest(Integer orderQuantity, String orderShippingAddress, Integer productId) {
        this.orderQuantity = orderQuantity;
        this.orderShippingAddress = orderShippingAddress;
        this.productId = productId;
    }

    public Integer getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(Integer orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public String getOrderShippingAddress() {
        return orderShippingAddress;
    }

    public void setOrderShippingAddress(String orderShippingAddress) {
        this.orderShippingAddress = orderShippingAddress;
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
                ", orderShippingAddress='" + orderShippingAddress + '\'' +
                ", productId=" + productId +
                '}';
    }
}
