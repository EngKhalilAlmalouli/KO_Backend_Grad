package com.example.ko_app.Point;

import java.util.Date;

public class PointRequest {
    private String pointName;
    private Integer pointValue;
    private String pointCreatedAt;
    private Integer customerId;

    public PointRequest(){}

    public PointRequest(String pointName, Integer pointValue, String pointCreatedAt, Integer customerId) {
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

    public String getPointCreatedAt() {
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
        return "PointRequest{" +
                "pointName='" + pointName + '\'' +
                ", pointValue=" + pointValue +
                ", pointCreatedAt='" + pointCreatedAt + '\'' +
                ", customerId=" + customerId +
                '}';
    }
}
