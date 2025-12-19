package com.creational.abstractfactory.payment.europe;

import com.creational.abstractfactory.payment.PaymentService;

public class SepaPaymentService implements PaymentService {

    @Override
    public void pay(double amount) {
        System.out.println("Paying €" + amount + " using SEPA");
    }
}

