package com.example.ko_app.Point;

public class PointResponse {
    private Integer pointId;
    private String pointName;
    private Integer pointValue;
    private String pointCreatedAt;
    private Integer customerId;

    public PointResponse(){}

    public PointResponse(Integer pointId, String pointName, Integer pointValue, String pointCreatedAt, Integer customerId) {
        this.pointId = pointId;
        this.pointName = pointName;
        this.pointValue = pointValue;
        this.pointCreatedAt = pointCreatedAt;
        this.customerId = customerId;
    }

    public Integer getPointId() {
        return pointId;
    }

    public void setPointId(Integer pointId) {
        this.pointId = pointId;
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
                "pointId=" + pointId +
                ", pointName='" + pointName + '\'' +
                ", pointValue=" + pointValue +
                ", pointCreatedAt='" + pointCreatedAt + '\'' +
                ", customerId=" + customerId +
                '}';
    }
}
