package com.example.ko_app.Report;

import com.example.ko_app.Configruration.NotFoundInDatabaseException;
import com.example.ko_app.Customer.Customer;
import com.example.ko_app.Customer.CustomerRepository;
import com.example.ko_app.Customer.CustomerRequest;
import com.example.ko_app.Customer.CustomerResponse;
import com.example.ko_app.validation.ObjectValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportService {
    private final ReportRepository reportRepository;
    private final CustomerRepository customerRepository;

    private final ObjectValidator<ReportRequest> validator;

    // Constructor for dependency injection
    public ReportService(ReportRepository reportRepository, CustomerRepository customerRepository, ObjectValidator<ReportRequest> validator) {
        this.reportRepository = reportRepository;
        this.customerRepository = customerRepository;
        this.validator = validator;
    }


    public List<?> getAllReport() {
        return reportRepository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    // getReportByID
    public ReportResponse getReportById(Integer id) {
      return reportRepository.findById(id)
               .map(this::mapToResponse)
              .orElseThrow(() -> new RuntimeException("Report not found"));
  }
    // getReportByCustomerID

    public List<ReportResponse> getReportsByCustomerId(Integer customerId) {
        List<Report> reports = reportRepository.findByCustomerId(customerId);
        return reports.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }



    // createReport
    public ReportResponse createReport(ReportRequest request) {
        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        validator.validate(request);

        Report report = new Report();
        report.setTitle(request.getReportTitle());
        report.setDescription(request.getReportDescription());
        report.setCreatedAt(request.getReportCreatedAt());
        report.setUpdatedAt(request.getReportUpdatedAt());
        report.setCustomer(customer);
        reportRepository.save(report);
        return mapToResponse(report);
    }

    // updateReport
    public ReportResponse updateReport(Integer id, ReportRequest request) {
        Report report = reportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Report not found"));
        validator.validate(request);

        report.setTitle(request.getReportTitle());
        report.setDescription(request.getReportDescription());
        report.setCreatedAt(request.getReportCreatedAt());
        report.setUpdatedAt(request.getReportUpdatedAt());
        report = reportRepository.save(report);
        return mapToResponse(report);
    }

    // deleteReport
    public ResponseEntity<?> deleteReport(Integer id) throws NotFoundInDatabaseException {
        Report report = reportRepository.findById(id)
                .orElseThrow(() -> new NotFoundInDatabaseException("Report not found"));

        reportRepository.delete(report); // Ensure the customer is actually deleted
        return ResponseEntity.status(HttpStatus.OK).body("Report deleted successfully");
    }

    // mapToResponse
    private ReportResponse mapToResponse(Report report) {
        List<Integer> reportIds = new ArrayList<>();
        ReportResponse response = new ReportResponse();
        response.setReportTitle(report.getTitle());
        response.setReportDescription(report.getDescription());
        response.setReportCreatedAt(report.getCreatedAt());
        response.setReportUpdatedAt(report.getUpdatedAt());
        response.setCustomerId(report.getCustomer().getId());
        return response;
    }
}
