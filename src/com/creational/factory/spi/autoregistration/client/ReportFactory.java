package com.creational.factory.spi.autoregistration.client;

import com.creational.factory.spi.autoregistration.model.Report;
import com.creational.factory.type.ReportType;

import java.util.*;

public class ReportFactory {

    private static final Map<ReportType, Report> REGISTRY;

    static {
        REGISTRY = loadReports();
    }

    private ReportFactory() {

    }

    private static Map<ReportType, Report> loadReports() {
        Map<ReportType, Report> tempRegistry = new EnumMap<>(ReportType.class);

        ServiceLoader<Report> loader = ServiceLoader.load(Report.class);

        for(Report report : loader) {
            ReportType key = report.getSupportedReportType();

            // Defensive check: avoid silent overrides
            if (tempRegistry.containsKey(key)) {
                throw new IllegalStateException(
                        "Duplicate Report found for key: " + key
                );
            }

            tempRegistry.put(key, report);
        }

        // Make registry immutable after startup

        return Collections.unmodifiableMap(tempRegistry);
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
