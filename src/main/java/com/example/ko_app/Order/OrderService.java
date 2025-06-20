package com.example.ko_app.Order;

import com.example.ko_app.Configruration.NotFoundInDatabaseException;
import com.example.ko_app.Customer.Customer;
import com.example.ko_app.Customer.CustomerRepository;
import com.example.ko_app.Point.Point;
import com.example.ko_app.Point.PointRepository;
import com.example.ko_app.Point.PointRequest;
import com.example.ko_app.Point.PointResponse;
import com.example.ko_app.Products.Product;
import com.example.ko_app.Products.ProductRepository;
import com.example.ko_app.validation.ObjectValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    ;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;


    private final ObjectValidator<OrderRequest> validator;

    // Constructor for dependency injection
    public OrderService(OrderRepository orderRepository, CustomerRepository customerRepository, ProductRepository productRepository, ObjectValidator<OrderRequest> validator) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
        this.validator = validator;
    }

    public List<?> getAllOrder() {
        return orderRepository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    // getOrderByID
    public OrderResponse getOrderById(Integer id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        return mapToResponse(order);
    }

    // getOrdersByCustomerId

//    public List<OrderResponse> getOrdersByCustomerId(Integer id) {
////        List<Order> orders = orderRepository.findByCustomerId(customerId);
//        return orderRepository.findById(id);
//    }

    // createOrder
    public OrderResponse createOrder(OrderRequest request) {


        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        validator.validate(request);
        Order order = new Order();
        order.setQuantity(request.getOrderQuantity());

        order.setShippingAddress(request.getOrderShippingAddress());

        List<Product> products = new ArrayList<>();
        products.add(product);
        order.setProducts(products);


        orderRepository.save(order);
        return mapToResponse(order);
    }

    // updateOrder //
    public OrderResponse updateOrder(Integer id, OrderRequest request) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));


        validator.validate(request);

        order.setQuantity(request.getOrderQuantity());
        order.setShippingAddress(request.getOrderShippingAddress());


        order = orderRepository.save(order);
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
        response.setOrderId(order.getId());
        response.setOrderQuantity(order.getQuantity());
        response.setProductId(order.getProducts().get(0).getId());


        return response;
    }
}
