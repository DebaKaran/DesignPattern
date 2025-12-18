package com.creational.factory.services;

import com.creational.factory.model.Report;

public class ExcelReport implements Report {

    @Override
    public String generate() {
        return "Generating excel report...";
    }
}

