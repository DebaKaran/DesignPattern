package com.creational.abstractfactory.invoice.europe;

import com.creational.abstractfactory.invoice.InvoiceService;

public class VatInvoiceService implements InvoiceService {

    @Override
    public void generateInvoice() {
        System.out.println("Generating VAT Invoice");
    }
}
