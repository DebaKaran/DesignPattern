package com.creational.abstractfactory.services.invoice.india;

import com.creational.abstractfactory.services.invoice.InvoiceService;

public class GstInvoiceService implements InvoiceService {

    @Override
    public void generateInvoice() {
        System.out.println("Generating GST Invoice (CGST + SGST)");
    }
}
