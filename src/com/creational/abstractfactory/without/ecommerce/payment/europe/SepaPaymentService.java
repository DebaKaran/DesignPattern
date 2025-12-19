package com.creational.abstractfactory.without.ecommerce.payment.europe;

import com.creational.abstractfactory.without.ecommerce.payment.PaymentService;

public class SepaPaymentService implements PaymentService {

    @Override
    public void pay(double amount) {
        System.out.println("Paying €" + amount + " using SEPA");
    }
}

