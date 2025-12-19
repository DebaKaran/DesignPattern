package com.creational.abstractfactory.region.europe;

import com.creational.abstractfactory.region.RegionOrderFactory;
import com.creational.abstractfactory.services.payment.PaymentService;
import com.creational.abstractfactory.services.payment.europe.EuropePaymentService;
import com.creational.abstractfactory.services.invoice.InvoiceService;
import com.creational.abstractfactory.services.invoice.europe.VatInvoiceService;
import com.creational.abstractfactory.services.shipping.ShippingService;
import com.creational.abstractfactory.services.shipping.europe.DhlShippingService;


public class EuropeOrderFactory implements RegionOrderFactory {

    @Override
    public InvoiceService createInvoice() {
        return new VatInvoiceService();
    }

    @Override
    public PaymentService createPayment() {
        return new EuropePaymentService();
    }

    @Override
    public ShippingService createShipping() {
        return new DhlShippingService();
    }
}
