package com.example.ko_app.Point;

public class PointResponse {
    private String pointName;
    private Integer pointValue;
    private String pointCreatedAt;
    private Integer customerId;

    public PointResponse(){}

    public PointResponse(String pointName, Integer pointValue, String pointCreatedAt, Integer customerId) {
        this.pointName = pointName;
        this.pointValue = pointValue;
        this.pointCreatedAt = pointCreatedAt;
        this.customerId = customerId;
    }

    public String getPointName() {
        return pointName;
    }

    public void setPointName(String pointName) {
        this.pointName = pointName;
    }

    public Integer getPointValue() {
        return pointValue;
    }

    public void setPointValue(Integer pointValue) {
        this.pointValue = pointValue;
    }

    public String getPointCreatedAt(String createdAt) {
        return pointCreatedAt;
    }

    public void setPointCreatedAt(String pointCreatedAt) {
        this.pointCreatedAt = pointCreatedAt;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "PointResponse{" +
                "pointName='" + pointName + '\'' +
                ", pointValue=" + pointValue +
                ", pointCreatedAt='" + pointCreatedAt + '\'' +
                ", customerId=" + customerId +
                '}';
    }
}
