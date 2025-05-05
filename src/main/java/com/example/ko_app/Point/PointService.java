package com.example.ko_app.Point;

import com.example.ko_app.Configruration.NotFoundInDatabaseException;
import com.example.ko_app.Products.Product;
import com.example.ko_app.Products.ProductRepository;
import com.example.ko_app.Products.ProductRequest;
import com.example.ko_app.Products.ProductResponse;
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
    private final ObjectValidator<PointRequest> validator;

    // Constructor for dependency injection
    public PointService(PointRepository pointRepository, ObjectValidator<PointRequest> validator) {
        this.pointRepository = pointRepository;
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

    // createPoint
    public PointResponse createPoint(PointRequest request) {
        validator.validate(request);
        Point point = new Point();
        point.setName(request.getPointName());
        point.setValue(request.getPointValue());
        point.setCreatedAt(request.getPointCreatedAt());

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
        response.setPointName(point.getName());
        response.setPointValue(point.getValue());
        response.getPointCreatedAt(point.getCreatedAt());

        return response;
    }
}
