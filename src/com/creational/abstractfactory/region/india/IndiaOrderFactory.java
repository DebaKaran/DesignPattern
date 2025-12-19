package com.creational.abstractfactory.region.india;

import com.creational.abstractfactory.region.RegionOrderFactory;
import com.creational.abstractfactory.services.payment.india.IndiaPaymentService;
import com.creational.abstractfactory.services.invoice.InvoiceService;
import com.creational.abstractfactory.services.payment.PaymentService;
import com.creational.abstractfactory.services.invoice.india.GstInvoiceService;
import com.creational.abstractfactory.services.shipping.ShippingService;
import com.creational.abstractfactory.services.shipping.india.DelhiveryShippingService;


public class IndiaOrderFactory implements RegionOrderFactory {

    @Override
    public InvoiceService createInvoice() {
        return new GstInvoiceService();
    }

    @Override
    public PaymentService createPayment() {
        return new IndiaPaymentService();
    }

    @Override
    public ShippingService createShipping() {
        return new DelhiveryShippingService();
    }
}
