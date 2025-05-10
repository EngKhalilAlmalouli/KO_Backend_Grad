package com.example.ko_app.Review;

public class ReviewRequest {
    private String reviewTitle;
    private String reviewDescription;
    private Integer customerId;


    public ReviewRequest() {}

    public ReviewRequest(String reviewTitle, String reviewDescription, Integer customerId) {
        this.reviewTitle = reviewTitle;
        this.reviewDescription = reviewDescription;
        this.customerId = customerId;
    }

    public String getReviewTitle() {
        return reviewTitle;
    }

    public void setReviewTitle(String reviewTitle) {
        this.reviewTitle = reviewTitle;
    }

    public String getReviewDescription() {
        return reviewDescription;
    }

    public void setReviewDescription(String reviewDescription) {
        this.reviewDescription = reviewDescription;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "ReviewRequest{" +
                "reviewTitle='" + reviewTitle + '\'' +
                ", reviewDescription='" + reviewDescription + '\'' +
                ", customerId=" + customerId +
                '}';
    }
}
