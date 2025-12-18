package com.creational.factory.spi.autoregistration.test;

import com.creational.factory.spi.autoregistration.client.ReportClient;
import com.creational.factory.spi.autoregistration.model.Report;
import com.creational.factory.type.ReportType;

public class ReportClientManualTest {

    public static void main(String[] args) {

        ReportClient reportClient = new ReportClient();

        testPdfReport(reportClient);
        testExcelReport(reportClient);
        testCsvReport(reportClient);
        testInvalidReportType(reportClient);

        System.out.println("All manual tests executed.");
    }

    private static void testPdfReport(ReportClient reportClient) {
        Report report = reportClient.getReport(ReportType.PDF);
        assertCondition(
                "Generating pdf report...".equals(report.generate()),
                "PDF report generation failed"
        );
    }

    private static void testExcelReport(ReportClient reportClient) {
        Report report = reportClient.getReport(ReportType.EXCEL);
        assertCondition(
                "Generating excel report...".equals(report.generate()),
                "Excel report generation failed"
        );
    }

    private static void testCsvReport(ReportClient reportClient) {
        Report report = reportClient.getReport(ReportType.CSV);
        assertCondition(
                "Generating CSV report...".equals(report.generate()),
                "CSV report generation failed"
        );
    }

    private static void testInvalidReportType(ReportClient reportClient) {
        try {
            reportClient.getReport(null);
            throw new RuntimeException("Expected exception not thrown for null type");
        } catch (IllegalArgumentException ex) {
            System.out.println("Invalid report type test passed.");
        }
    }

    private static void assertCondition(boolean condition, String errorMessage) {
        if (!condition) {
            throw new RuntimeException(errorMessage);
        }
        System.out.println("Test passed.");
    }
}
