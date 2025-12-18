package com.creational.factory.spi.autoregistration.model;

import com.creational.factory.type.ReportType;

public interface Report {

    String generate();

    ReportType getSupportedReportType();
}
