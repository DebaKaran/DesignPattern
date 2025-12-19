package com.creational.abstractfactory.region.usa;

import com.creational.abstractfactory.services.payment.usa.USAPaymentService;
import com.creational.abstractfactory.region.RegionOrderFactory;
import com.creational.abstractfactory.services.payment.PaymentService;
import com.creational.abstractfactory.services.invoice.InvoiceService;
import com.creational.abstractfactory.services.invoice.usa.SalesTaxInvoiceService;
import com.creational.abstractfactory.services.shipping.ShippingService;
import com.creational.abstractfactory.services.shipping.usa.FedexShippingService;


public class USAOrderFactory implements RegionOrderFactory {

    @Override
    public InvoiceService createInvoice() {
        return new SalesTaxInvoiceService();
    }

    @Override
    public PaymentService createPayment() {
        return new USAPaymentService();
    }

    @Override
    public ShippingService createShipping() {
        return new FedexShippingService();
    }
}
