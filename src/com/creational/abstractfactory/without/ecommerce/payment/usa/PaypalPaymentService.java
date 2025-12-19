package com.creational.abstractfactory.payment.usa;

import com.creational.abstractfactory.payment.PaymentService;

public class PaypalPaymentService implements PaymentService {

    @Override
    public void pay(double amount) {
        System.out.println("Paying $" + amount + " using PayPal");
    }
}

