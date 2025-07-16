package com.example.ko_app.Order;

import com.example.ko_app.Categories.CategoryResponse;

import java.util.List;

public class OrderListResponse {
    private List<OrderResponse> orders;

    // Constructor
    public OrderListResponse(List<OrderResponse> orders) {
        this.orders = orders;
    }

    public List<OrderResponse> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderResponse> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "OrderListResponse{" +
                "orders=" + orders +
                '}';
    }
}
