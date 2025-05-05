package com.example.ko_app.Point;

import java.util.Date;

public class PointResponse {
    private String pointName;
    private Integer pointValue;
    private Date pointCreatedAt;

    public PointResponse(){}

    public PointResponse(String pointName, Integer pointValue, Date pointCreatedAt) {
        this.pointName = pointName;
        this.pointValue = pointValue;
        this.pointCreatedAt = pointCreatedAt;
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

    public Date getPointCreatedAt(Date createdAt) {
        return pointCreatedAt;
    }

    public void setPointCreatedAt(Date pointCreatedAt) {
        this.pointCreatedAt = pointCreatedAt;
    }

    @Override
    public String toString() {
        return "PointResponse{" +
                "pointName='" + pointName + '\'' +
                ", pointValue=" + pointValue +
                ", pointCreationAt=" + pointCreatedAt +
                '}';
    }
}
