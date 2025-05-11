package com.example.ko_app.Order;

import com.example.ko_app.Configruration.NotFoundInDatabaseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    // Constructor for dependency injection
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<?>> getAllOrder() {
        return ResponseEntity.ok(orderService.getAllOrder());
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<OrderResponse>> getOrdersByCustomer(@PathVariable Integer customerId) {
        return ResponseEntity.ok(orderService.getOrdersByCustomerId(customerId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @PostMapping
    public OrderResponse createOrder(@RequestBody OrderRequest request) {
        return orderService.createOrder(request);
    }

    @PutMapping("/{id}")
    public OrderResponse updateOrder(@PathVariable Integer id, @RequestBody OrderRequest request) {
        return orderService.updateOrder(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Integer id) throws NotFoundInDatabaseException {
        return orderService.deleteOrder(id);
    }
}
