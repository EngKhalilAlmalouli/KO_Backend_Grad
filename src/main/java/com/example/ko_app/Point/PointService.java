package com.example.ko_app.Point;

import com.example.ko_app.Configruration.NotFoundInDatabaseException;
import com.example.ko_app.Customer.Customer;
import com.example.ko_app.Customer.CustomerRepository;
import com.example.ko_app.Products.Product;
import com.example.ko_app.Products.ProductRepository;
import com.example.ko_app.Products.ProductRequest;
import com.example.ko_app.Products.ProductResponse;
import com.example.ko_app.Report.Report;
import com.example.ko_app.Report.ReportResponse;
import com.example.ko_app.validation.ObjectValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PointService {
    private final PointRepository pointRepository; ;
    private final CustomerRepository customerRepository;
    private final ObjectValidator<PointRequest> validator;

    // Constructor for dependency injection
    public PointService(PointRepository pointRepository, CustomerRepository customerRepository, ObjectValidator<PointRequest> validator) {
        this.pointRepository = pointRepository;
        this.customerRepository = customerRepository;
        this.validator = validator;
    }

    public List<?> getAllPoint() {
        return pointRepository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    // getPointByID
    public PointResponse getPointById(Integer id) {
        return pointRepository.findById(id)
                .map(this::mapToResponse)
                .orElseThrow(() -> new RuntimeException("Point not found"));
    }

    // getReportByCustomerID
    public List<PointResponse> getPointsByCustomerId(Integer customerId) {
        List<Point> points = pointRepository.findByCustomerId(customerId);
        return points.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // createPoint
    public PointResponse createPoint(PointRequest request) {
        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        validator.validate(request);


        Point point = new Point();
        point.setName(request.getPointName());
        point.setValue(request.getPointValue());
        point.setCreatedAt(request.getPointCreatedAt());
        point.setCustomer(customer);

        pointRepository.save(point);
        return mapToResponse(point);
    }

    // updatePoint //
    public PointResponse updatePoint(Integer id, PointRequest request) {
        Point point = pointRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Point not found"));
        validator.validate(request);

        point.setName(request.getPointName());
        point.setValue(request.getPointValue());
        point.setCreatedAt(request.getPointCreatedAt());

        point =pointRepository.save(point);
        return mapToResponse(point);
    }

    // deletePoint
    public ResponseEntity<?> deletePoint(Integer id) throws NotFoundInDatabaseException {
        Point point = pointRepository.findById(id)
                .orElseThrow(() -> new NotFoundInDatabaseException("Point not found"));

        pointRepository.delete(point);
        return ResponseEntity.status(HttpStatus.OK).body("Point deleted successfully");
    }

    // mapToResponse
    private PointResponse mapToResponse(Point point) {
        List<Integer> pointIds = new ArrayList<>();
        PointResponse response = new PointResponse();
        response.setPointId(point.getId());
        response.setPointName(point.getName());
        response.setPointValue(point.getValue());
        response.getPointCreatedAt(point.getCreatedAt());
        response.setCustomerId(point.getCustomer().getId());

        return response;
    }
}
