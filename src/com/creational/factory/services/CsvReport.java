package com.creational.factory.services;

import com.creational.factory.model.Report;

public class CsvReport  implements Report {

    @Override
    public String generate() {
        return "Generating CSV report...";
    }
}
