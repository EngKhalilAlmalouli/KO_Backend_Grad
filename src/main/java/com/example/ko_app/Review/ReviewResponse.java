package com.example.ko_app.Review;

public class ReviewResponse {
    private Integer reviewId;
    private String reviewTitle;
    private String reviewDescription;

    public ReviewResponse(){}

    public ReviewResponse(Integer reviewId, String reviewTitle, String reviewDescription) {
        this.reviewId = reviewId;
        this.reviewTitle = reviewTitle;
        this.reviewDescription = reviewDescription;
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
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

    @Override
    public String toString() {
        return "ReviewResponse{" +
                "reviewId=" + reviewId +
                ", reviewTitle='" + reviewTitle + '\'' +
                ", reviewDescription='" + reviewDescription + '\'' +
                '}';
    }
}
