package com.creational.abstractfactory.without.ecommerce.order;

import com.creational.abstractfactory.types.Country;
import com.creational.abstractfactory.types.PaymentMethod;
import com.creational.abstractfactory.without.ecommerce.invoice.InvoiceService;
import com.creational.abstractfactory.without.ecommerce.invoice.europe.VatInvoiceService;
import com.creational.abstractfactory.without.ecommerce.invoice.india.GstInvoiceService;
import com.creational.abstractfactory.without.ecommerce.invoice.usa.SalesTaxInvoiceService;
import com.creational.abstractfactory.without.ecommerce.payment.PaymentService;
import com.creational.abstractfactory.without.ecommerce.payment.europe.SepaPaymentService;
import com.creational.abstractfactory.without.ecommerce.payment.india.CreditCardPaymentService;
import com.creational.abstractfactory.without.ecommerce.payment.india.UpiPaymentService;
import com.creational.abstractfactory.without.ecommerce.payment.usa.CreditCardPaymentServiceUSA;
import com.creational.abstractfactory.without.ecommerce.payment.usa.PaypalPaymentService;
import com.creational.abstractfactory.without.ecommerce.shipping.ShippingService;
import com.creational.abstractfactory.without.ecommerce.shipping.europe.DhlShippingService;
import com.creational.abstractfactory.without.ecommerce.shipping.india.DelhiveryShippingService;
import com.creational.abstractfactory.without.ecommerce.shipping.usa.FedexShippingService;

public class OrderService {

    public void placeOrder(
            Country country,
            PaymentMethod paymentMethod,
            double amount
    ) {

        PaymentService paymentService;
        InvoiceService invoiceService;
        ShippingService shippingService;

        // COUNTRY-BASED DECISION HELL 🔥
        if (country == Country.INDIA) {

            if (paymentMethod == PaymentMethod.UPI) {
                paymentService = new UpiPaymentService();
            } else {
                paymentService = new CreditCardPaymentService();
            }

            invoiceService = new GstInvoiceService();
            shippingService = new DelhiveryShippingService();

        } else if (country == Country.USA) {

            if (paymentMethod == PaymentMethod.PAYPAL) {
                paymentService = new PaypalPaymentService();
            } else {
                paymentService = new CreditCardPaymentServiceUSA();
            }

            invoiceService = new SalesTaxInvoiceService();
            shippingService = new FedexShippingService();

        } else if (country == Country.EUROPE) {

            paymentService = new SepaPaymentService();
            invoiceService = new VatInvoiceService();
            shippingService = new DhlShippingService();

        } else {
            throw new IllegalArgumentException("Unsupported country");
        }

        // Business flow
        paymentService.pay(amount);
        invoiceService.generateInvoice();
        shippingService.shipOrder();

        System.out.println("Order placed successfully\n");
    }
}
