package com.example.ko_app.Report;

import com.example.ko_app.Configruration.NotFoundInDatabaseException;
import com.example.ko_app.Customer.CustomerRequest;
import com.example.ko_app.Customer.CustomerResponse;
import com.example.ko_app.Customer.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/reports")
public class ReportController {
    private final ReportService reportService;

    // Constructor for dependency injection

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping
    public ResponseEntity<List<?>> getAllReport() {
        return ResponseEntity.ok(reportService.getAllReport());
    }

    @GetMapping("/{id}")
    public ReportResponse getReportById(@PathVariable Integer id) {
        return reportService.getReportById(id);
    }

    @PostMapping
    public ReportResponse createReport(@RequestBody ReportRequest request) {
        return reportService.createReport(request);
    }

    @PutMapping("/{id}")
    public ReportResponse updateReport(@PathVariable Integer id, @RequestBody ReportRequest request) {
        return reportService.updateReport(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReport(@PathVariable Integer id) throws NotFoundInDatabaseException {
        return reportService.deleteReport(id);
    }
}
