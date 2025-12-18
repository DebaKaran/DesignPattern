package com.creational.factory.spi.autoregistration.services;


import com.creational.factory.spi.autoregistration.model.Report;
import com.creational.factory.type.ReportType;

public class ExcelReport implements Report {

    @Override
    public String generate() {
        return "Generating excel report...";
    }

    @Override
    public ReportType getSupportedReportType() {
        return ReportType.EXCEL;
    }
}

