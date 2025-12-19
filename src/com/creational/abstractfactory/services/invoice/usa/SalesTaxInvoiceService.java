package com.creational.abstractfactory.services.invoice.usa;

import com.creational.abstractfactory.services.invoice.InvoiceService;

public class SalesTaxInvoiceService implements InvoiceService {

    @Override
    public void generateInvoice() {
        System.out.println("Generating US Sales Tax Invoice");
    }
}
