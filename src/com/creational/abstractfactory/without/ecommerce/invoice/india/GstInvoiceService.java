package com.creational.abstractfactory.without.ecommerce.invoice.india;

import com.creational.abstractfactory.without.ecommerce.invoice.InvoiceService;

public class GstInvoiceService implements InvoiceService {

    @Override
    public void generateInvoice() {
        System.out.println("Generating GST Invoice (CGST + SGST)");
    }
}
