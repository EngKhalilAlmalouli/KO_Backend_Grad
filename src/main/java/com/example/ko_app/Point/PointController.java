package com.example.ko_app.Point;


import com.example.ko_app.Configruration.NotFoundInDatabaseException;
import com.example.ko_app.Products.ProductResponse;
import com.example.ko_app.Report.ReportResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/points")
public class PointController {
    private final PointService pointService;

    // Constructor for dependency injection
    public PointController(PointService pointService) {
        this.pointService = pointService;
    }

    @GetMapping
    public ResponseEntity<List<?>> getAllpoint() {
        return ResponseEntity.ok(pointService.getAllPoint());
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<PointResponse>> getPointByCustomer(@PathVariable Integer customerId) {
        return ResponseEntity.ok(pointService.getPointsByCustomerId(customerId));
    }

    @GetMapping("/{id}")
    public PointResponse getPointById(@PathVariable Integer id) {
        return pointService.getPointById(id);
    }

    @PostMapping
    public PointResponse createPoint(@RequestBody PointRequest request) {
        return pointService.createPoint(request);
    }

    @PutMapping("/{id}")
    public PointResponse updatePoint(@PathVariable Integer id, @RequestBody PointRequest request) {
        return pointService.updatePoint(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePoint(@PathVariable Integer id) throws NotFoundInDatabaseException {
        return pointService.deletePoint(id);
    }
}
