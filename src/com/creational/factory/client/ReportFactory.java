package com.creational.factory.client;

import com.creational.factory.model.Report;
import com.creational.factory.services.CsvReport;
import com.creational.factory.services.ExcelReport;
import com.creational.factory.services.PdfReport;
import com.creational.factory.type.ReportType;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ReportFactory {

    private static final Map<ReportType, Report> REGISTRY = new ConcurrentHashMap<>();

    static {
        REGISTRY.put(ReportType.PDF, new PdfReport());
        REGISTRY.put(ReportType.CSV, new CsvReport());
        REGISTRY.put(ReportType.EXCEL, new ExcelReport());
    }

    public static Report getReport(final ReportType type) {

        if (type == null) {
            throw new IllegalArgumentException("Report type cannot be null");
        }

        Report report = REGISTRY.get(type);

        if(report == null) {
            throw new IllegalArgumentException("Unsupported report type");
        }

        return report;
    }
}
