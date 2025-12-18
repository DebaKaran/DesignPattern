package com.creational.factory.spi.autoregistration.client;

import com.creational.factory.spi.autoregistration.model.Report;
import com.creational.factory.type.ReportType;

public class ReportClient {

    public Report getReport(final ReportType type) {
        return ReportFactory.getReport(type);
    }
}
