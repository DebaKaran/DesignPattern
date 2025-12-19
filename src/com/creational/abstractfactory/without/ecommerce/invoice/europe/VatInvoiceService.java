package com.creational.abstractfactory.without.ecommerce.invoice.europe;

import com.creational.abstractfactory.without.ecommerce.invoice.InvoiceService;

public class VatInvoiceService implements InvoiceService {

    @Override
    public void generateInvoice() {
        System.out.println("Generating VAT Invoice");
    }
}
