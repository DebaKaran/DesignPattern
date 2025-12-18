package com.creational.factory.client;

import com.creational.factory.model.Report;
import com.creational.factory.services.CsvReport;
import com.creational.factory.services.ExcelReport;
import com.creational.factory.services.PdfReport;
import com.creational.factory.type.ReportType;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class ReportFactory {

private static final Map<ReportType, Report> REGISTRY =
        Collections.unmodifiableMap(
            new EnumMap<>(Map.of(
                ReportType.PDF, new PdfReport(),
                ReportType.CSV, new CsvReport(),
                ReportType.EXCEL, new ExcelReport()
            ))
        );

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
