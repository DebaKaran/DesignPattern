package com.creational.abstractfactory.without.ecommerce.invoice.usa;

import com.creational.abstractfactory.without.ecommerce.invoice.InvoiceService;

public class SalesTaxInvoiceService implements InvoiceService {

    @Override
    public void generateInvoice() {
        System.out.println("Generating US Sales Tax Invoice");
    }
}
