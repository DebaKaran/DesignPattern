package com.creational.factory.spi.autoregistration.services;


import com.creational.factory.spi.autoregistration.model.Report;
import com.creational.factory.type.ReportType;

public class PdfReport implements Report {

    @Override
    public String generate() {
        return "Generating pdf report...";
    }

    @Override
    public ReportType getSupportedReportType() {
        return ReportType.PDF;
    }
}
