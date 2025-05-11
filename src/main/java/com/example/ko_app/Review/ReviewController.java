package com.example.ko_app.Review;


import com.example.ko_app.Configruration.NotFoundInDatabaseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    // Constructor for dependency injection

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public ResponseEntity<List<?>> getAllReviews() {
        return ResponseEntity.ok(reviewService.getAllReview());
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<ReviewResponse>> getReviewsByCustomer(@PathVariable Integer customerId) {
        return ResponseEntity.ok(reviewService.getReviewsByCustomerId(customerId));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ReviewResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(reviewService.getReviewById(id));
    }

    @PostMapping
    public ReviewResponse createReview(@RequestBody ReviewRequest request) {
        return reviewService.createReview(request);
    }

    @PutMapping("/{id}")
    public ReviewResponse updateReiew(@PathVariable Integer id, @RequestBody ReviewRequest request) {
        return reviewService.updateReview(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReview(@PathVariable Integer id) throws NotFoundInDatabaseException {
        return reviewService.deleteReview(id);
    }
}
