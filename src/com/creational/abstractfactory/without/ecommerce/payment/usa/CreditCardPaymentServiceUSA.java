package com.creational.abstractfactory.payment.usa;

import com.creational.abstractfactory.payment.PaymentService;

public class CreditCardPaymentServiceUSA implements PaymentService {

    @Override
    public void pay(double amount) {
        System.out.println("Paying $" + amount + " using Credit Card");
    }
}
