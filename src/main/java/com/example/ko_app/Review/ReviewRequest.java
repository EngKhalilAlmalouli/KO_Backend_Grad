package com.example.ko_app.Review;

public class ReviewRequest {
    private String reviewTitle;
    private String reviewDescription;

    public ReviewRequest() {}
    public ReviewRequest(String reviewTitle, String reviewDescription) {
        this.reviewTitle = reviewTitle;
        this.reviewDescription = reviewDescription;
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
        return "ReviewRequest{" +
                "reviewTitle='" + reviewTitle + '\'' +
                ", reviewDescription='" + reviewDescription + '\'' +
                '}';
    }
}
