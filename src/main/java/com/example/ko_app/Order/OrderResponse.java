package com.example.ko_app.Order;

import java.util.Date;

public class OrderResponse {
    private Integer orderId;
    private Integer orderQuantity;
    private Integer productId;



    public OrderResponse() {}


    public OrderResponse(Integer orderId, Integer orderQuantity, Integer productId) {
        this.orderId = orderId;
        this.orderQuantity = orderQuantity;
        this.productId = productId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(Integer orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "OrderResponse{" +
                "orderId=" + orderId +
                ", orderQuantity=" + orderQuantity +
                ", productId=" + productId +
                '}';
    }
}
