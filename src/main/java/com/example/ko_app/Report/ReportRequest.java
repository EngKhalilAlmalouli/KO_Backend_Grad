package com.example.ko_app.Report;

import java.util.Date;

public class ReportRequest {
    private String reportTitle;
    private String reportDescription;
    private String reportCreatedAt;
    private String reportUpdatedAt;
    private Integer customerId;

    public ReportRequest() {}

    public ReportRequest(String reportTitle, String reportDescription, String reportCreatedAt, String reportUpdatedAt, Integer customerId) {
        this.reportTitle = reportTitle;
        this.reportDescription = reportDescription;
        this.reportCreatedAt = reportCreatedAt;
        this.reportUpdatedAt = reportUpdatedAt;
        this.customerId = customerId;
    }

    public String getReportTitle() {
        return reportTitle;
    }

    public void setReportTitle(String reportTitle) {
        this.reportTitle = reportTitle;
    }

    public String getReportDescription() {
        return reportDescription;
    }

    public void setReportDescription(String reportDescription) {
        this.reportDescription = reportDescription;
    }

    public String getReportCreatedAt() {
        return reportCreatedAt;
    }

    public void setReportCreatedAt(String reportCreatedAt) {
        this.reportCreatedAt = reportCreatedAt;
    }

    public String getReportUpdatedAt() {
        return reportUpdatedAt;
    }

    public void setReportUpdatedAt(String reportUpdatedAt) {
        this.reportUpdatedAt = reportUpdatedAt;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "ReportRequest{" +
                "reportTitle='" + reportTitle + '\'' +
                ", reportDescription='" + reportDescription + '\'' +
                ", reportCreatedAt='" + reportCreatedAt + '\'' +
                ", reportUpdatedAt='" + reportUpdatedAt + '\'' +
                ", customerId=" + customerId +
                '}';
    }
}
