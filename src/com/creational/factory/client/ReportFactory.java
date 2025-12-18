package com.creational.factory.client;

import com.creational.factory.model.Report;
import com.creational.factory.services.CsvReport;
import com.creational.factory.services.ExcelReport;
import com.creational.factory.services.PdfReport;
import com.creational.factory.type.ReportType;

public class ReportFactory {

    public static Report getReport(final ReportType type) {

        if (type == null) {
            throw new IllegalArgumentException("Report type cannot be null");
        }

        switch (type) {
            case CSV -> {
                return new CsvReport();
            }
            case PDF -> {
                return new PdfReport();
            }
            case EXCEL -> {
                return new ExcelReport();
            }
            default -> throw new IllegalArgumentException("Unsupported report type");
        }
    }
}
