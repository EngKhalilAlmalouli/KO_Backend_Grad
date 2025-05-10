package com.example.ko_app.Order;

import com.example.ko_app.Configruration.NotFoundInDatabaseException;
import com.example.ko_app.Point.Point;
import com.example.ko_app.Point.PointRepository;
import com.example.ko_app.Point.PointRequest;
import com.example.ko_app.Point.PointResponse;
import com.example.ko_app.validation.ObjectValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final OrderRepository orderRepository; ;
    private final ObjectValidator<OrderRequest> validator;

    // Constructor for dependency injection
    public OrderService(OrderRepository orderRepository, ObjectValidator<OrderRequest> validator) {
        this.orderRepository = orderRepository;
        this.validator = validator;
    }

    public List<?> getAllOrder() {
        return orderRepository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    // getOrderByID
    public OrderResponse getOrderById(Integer id) {
        return orderRepository.findById(id)
                .map(this::mapToResponse)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    // createOrder
    public OrderResponse createOrder(OrderRequest request) {
        validator.validate(request);
        Order order = new Order();
        order.setQuantity(request.getOrderQuantity());
        order.setTotal(request.getOrderTotal());
        order.setSubTotal(request.getOrderSubTotal());
        order.setStatus(request.getOrderStatus());
        order.setShippingAddress(request.getOrderShippingAddress());
        order.setTotalPrice(request.getOrderTotalPrice());
        order.setCreateAt(request.getOrderCreateAt());
        order.setUpdateAt(request.getOrderUpdateAt());

        orderRepository.save(order);
        return mapToResponse(order);
    }

    // updateOrder //
    public OrderResponse updateOrder(Integer id, OrderRequest request) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        validator.validate(request);

        order.setQuantity(request.getOrderQuantity());
        order.setTotal(request.getOrderTotal());
        order.setSubTotal(request.getOrderSubTotal());
        order.setStatus(request.getOrderStatus());
        order.setShippingAddress(request.getOrderShippingAddress());
        order.setTotalPrice(request.getOrderTotalPrice());
        order.setCreateAt(request.getOrderCreateAt());
        order.setUpdateAt(request.getOrderUpdateAt());

        order =orderRepository.save(order);
        return mapToResponse(order);
    }

    // deleteOrder
    public ResponseEntity<?> deleteOrder(Integer id) throws NotFoundInDatabaseException {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundInDatabaseException("Order not found"));

        orderRepository.delete(order);
        return ResponseEntity.status(HttpStatus.OK).body("Order deleted successfully");
    }

    // mapToResponse
    private OrderResponse mapToResponse(Order order) {
        List<Integer> orderIds = new ArrayList<>();
        OrderResponse response = new OrderResponse();
        response.setOrderQuantity(order.getQuantity());
        response.setOrderStatus(order.getStatus());
        response.setOrderTotal(order.getTotal());
        response.setOrderSubTotal(order.getSubTotal());
        response.setOrderShippingAddress(order.getShippingAddress());
        response.setOrderCreateAt(order.getCreateAt());
        response.setOrderUpdateAt(order.getUpdateAt());
        response.setOrderTotalPrice(order.getTotalPrice());

        return response;
    }
}
