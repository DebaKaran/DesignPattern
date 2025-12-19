package com.creational.abstractfactory.order;

import com.creational.abstractfactory.region.RegionOrderFactory;
import com.creational.abstractfactory.services.invoice.InvoiceService;
import com.creational.abstractfactory.services.payment.PaymentService;
import com.creational.abstractfactory.services.shipping.ShippingService;
import com.creational.abstractfactory.types.PaymentType;

public class OrderService {

    private final RegionOrderFactory regionOrderFactory;

    public OrderService(RegionOrderFactory regionOrderFactory) {
        this.regionOrderFactory = regionOrderFactory;
    }

    public void placeOrder(double amount, PaymentType paymentType) {
        // Create region-compatible components
        PaymentService payment = regionOrderFactory.createPayment();
        InvoiceService invoice = regionOrderFactory.createInvoice();
        ShippingService shipping = regionOrderFactory.createShipping();

        // Orchestrate business flow
        payment.pay(amount, paymentType);
        invoice.generateInvoice();
        shipping.shipOrder();

        System.out.println("Order placed successfully\n");
    }

}
