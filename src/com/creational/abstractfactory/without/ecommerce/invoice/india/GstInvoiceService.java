package com.creational.abstractfactory.invoice.india;

import com.creational.abstractfactory.invoice.InvoiceService;

public class GstInvoiceService implements InvoiceService {

    @Override
    public void generateInvoice() {
        System.out.println("Generating GST Invoice (CGST + SGST)");
    }
}
