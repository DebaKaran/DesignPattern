package com.creational.factory.services;

import com.creational.factory.model.Report;

public class PdfReport implements Report {

    @Override
    public String generate() {
        return "Generating pdf report...";
    }
}
