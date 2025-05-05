package com.example.ko_app.Report;

import java.util.Date;

public class ReportRequest {
    private String reportTitle;
    private String reportDescription;
    private String reportCreatedAt;
    private String reportUpdatedAt;

    public ReportRequest() {}
    public ReportRequest(String reportTitle, String reportDescription, Date reportCreatedAt, String reportUpdatedAt) {
        this.reportTitle = reportTitle;
        this.reportDescription = reportDescription;
        this.reportCreatedAt = String.valueOf(reportCreatedAt);
        this.reportUpdatedAt = reportUpdatedAt;
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

    @Override
    public String toString() {
        return "ReportRequest{" +
                "reportTitle='" + reportTitle + '\'' +
                ", reportDescription='" + reportDescription + '\'' +
                ", reportCreatedAt=" + reportCreatedAt +
                ", reportUpdatedAt='" + reportUpdatedAt + '\'' +
                '}';
    }
}
