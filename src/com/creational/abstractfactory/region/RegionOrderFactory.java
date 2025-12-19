package com.creational.abstractfactory.region;


import com.creational.abstractfactory.services.invoice.InvoiceService;
import com.creational.abstractfactory.services.payment.PaymentService;
import com.creational.abstractfactory.services.shipping.ShippingService;

public interface RegionOrderFactory {
    InvoiceService createInvoice();
    PaymentService createPayment();
    ShippingService createShipping();
}
