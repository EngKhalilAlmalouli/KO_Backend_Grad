package com.example.ko_app.Point;

import java.util.Date;

public class PointRequest {
    private String pointName;
    private Integer pointValue;
    private Date pointCreatedAt;

    public PointRequest(){}

    public PointRequest(String pointName, Integer pointValue, Date pointCreationAt) {
        this.pointName = pointName;
        this.pointValue = pointValue;
        this.pointCreatedAt = pointCreationAt;
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

    public Date getPointCreatedAt() {
        return pointCreatedAt;
    }

    public void setPointCreatedAt(Date pointCreatedAt) {
        this.pointCreatedAt = pointCreatedAt;
    }

    @Override
    public String toString() {
        return "PointRequest{" +
                "pointName='" + pointName + '\'' +
                ", pointValue=" + pointValue +
                ", pointCreationAt=" + pointCreatedAt +
                '}';
    }
}
