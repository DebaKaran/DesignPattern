package com.creational.factory.client;

import com.creational.factory.model.Report;
import com.creational.factory.type.ReportType;

public class ReportClient {

    public Report getReport(final ReportType type) {
        return ReportFactory.getReport(type);
    }
}
