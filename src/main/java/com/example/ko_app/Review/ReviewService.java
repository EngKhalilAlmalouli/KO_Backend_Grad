package com.example.ko_app.Review;

import com.example.ko_app.Configruration.NotFoundInDatabaseException;
import com.example.ko_app.Customer.Customer;
import com.example.ko_app.Customer.CustomerRepository;
import com.example.ko_app.Report.Report;
import com.example.ko_app.Report.ReportRepository;
import com.example.ko_app.Report.ReportRequest;
import com.example.ko_app.Report.ReportResponse;
import com.example.ko_app.validation.ObjectValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final CustomerRepository customerRepository;

    private final ObjectValidator<ReviewRequest> validator;

    // Constructor for dependency injection
    public ReviewService(ReviewRepository reviewRepository, CustomerRepository customerRepository, ObjectValidator<ReviewRequest> validator) {
        this.reviewRepository = reviewRepository;
        this.customerRepository = customerRepository;
        this.validator = validator;
    }

    public List<?> getAllReview() {
        return reviewRepository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
    }


    // getReportByID
    public ReviewResponse getReviewById(Integer id) {
        return reviewRepository.findById(id)
                .map(this::mapToResponse)
                .orElseThrow(() -> new RuntimeException("Review not found"));
    }

    public List<ReviewResponse> getReviewsByCustomerId(Integer customerId) {
        return reviewRepository.findByCustomerId(customerId).stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // createReview
    public ReviewResponse createReview(ReviewRequest request) {
        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        validator.validate(request);
        Review review = new Review();
        review.setTitle(request.getReviewTitle());
        review.setDescription(request.getReviewDescription());
        review.setCustomer(customer);
        reviewRepository.save(review);
        return mapToResponse(review);
    }

    // updateReview
    public ReviewResponse updateReview(Integer id, ReviewRequest request) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found"));
        validator.validate(request);

        review.setTitle(request.getReviewTitle());
        review.setDescription(request.getReviewDescription());
        review = reviewRepository.save(review);
        return mapToResponse(review);
    }

    // deleteReview
    public ResponseEntity<?> deleteReview(Integer id) throws NotFoundInDatabaseException {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new NotFoundInDatabaseException("Review not found"));

        reviewRepository.delete(review); // Ensure the customer is actually deleted
        return ResponseEntity.status(HttpStatus.OK).body("Review deleted successfully");
    }

    // mapToResponse
    private ReviewResponse mapToResponse(Review review) {
        List<Integer> reviewIds = new ArrayList<>();
        ReviewResponse response = new ReviewResponse();
        response.setReviewId(review.getId());
        response.setReviewTitle(review.getTitle());
        response.setReviewDescription(review.getDescription());
        response.setCustomerId(review.getCustomer().getId());
        return response;
    }
}
