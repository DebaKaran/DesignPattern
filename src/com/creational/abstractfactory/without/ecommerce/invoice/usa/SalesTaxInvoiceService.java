package com.creational.abstractfactory.invoice.usa;

import com.creational.abstractfactory.invoice.InvoiceService;

public class SalesTaxInvoiceService implements InvoiceService {

    @Override
    public void generateInvoice() {
        System.out.println("Generating US Sales Tax Invoice");
    }
}
