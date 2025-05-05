package com.example.ko_app.Report;

import java.util.Date;

public class ReportResponse {
    private Integer ReportId;
    private String ReportTitle;
    private String ReportDescription;
    private String ReportCreatedAt;
    private String ReportUpdatedAt;

    public ReportResponse() {}

    public ReportResponse(Integer reportId, String reportTitle, String reportDescription, Date reportCreatedAt, Date reportUpdatedAt) {
        ReportId = reportId;
        ReportTitle = reportTitle;
        ReportDescription = reportDescription;
        ReportCreatedAt = String.valueOf(reportCreatedAt);
        ReportUpdatedAt = String.valueOf(reportUpdatedAt);
    }

    public Integer getReportId() {
        return ReportId;
    }

    public void setReportId(Integer reportId) {
        ReportId = reportId;
    }

    public String getReportTitle() {
        return ReportTitle;
    }

    public void setReportTitle(String reportTitle) {
        ReportTitle = reportTitle;
    }

    public String getReportDescription() {
        return ReportDescription;
    }

    public void setReportDescription(String reportDescription) {
        ReportDescription = reportDescription;
    }

    public String getReportCreatedAt() {
        return ReportCreatedAt;
    }

    public void setReportCreatedAt(String reportCreatedAt) {
        ReportCreatedAt = reportCreatedAt;
    }

    public String getReportUpdatedAt() {
        return ReportUpdatedAt;
    }

    public void setReportUpdatedAt(String reportUpdatedAt) {
        ReportUpdatedAt = reportUpdatedAt;
    }

    @Override
    public String toString() {
        return "ReportResponse{" +
                "ReportId=" + ReportId +
                ", ReportTitle='" + ReportTitle + '\'' +
                ", ReportDescription='" + ReportDescription + '\'' +
                ", ReportCreatedAt=" + ReportCreatedAt +
                ", ReportUpdatedAt=" + ReportUpdatedAt +
                '}';
    }
}
