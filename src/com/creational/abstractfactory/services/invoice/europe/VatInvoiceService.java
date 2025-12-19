package com.creational.abstractfactory.services.invoice.europe;

import com.creational.abstractfactory.services.invoice.InvoiceService;

public class VatInvoiceService implements InvoiceService {

    @Override
    public void generateInvoice() {
        System.out.println("Generating VAT Invoice");
    }
}
