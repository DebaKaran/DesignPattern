package com.creational.abstractfactory.without.ecommerce.payment.usa;

import com.creational.abstractfactory.without.ecommerce.payment.PaymentService;

public class CreditCardPaymentServiceUSA implements PaymentService {

    @Override
    public void pay(double amount) {
        System.out.println("Paying $" + amount + " using Credit Card");
    }
}
