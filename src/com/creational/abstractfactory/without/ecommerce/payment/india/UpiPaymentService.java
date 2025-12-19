package com.creational.abstractfactory.without.ecommerce.payment.india;

import com.creational.abstractfactory.without.ecommerce.payment.PaymentService;

public class UpiPaymentService implements PaymentService {

    @Override
    public void pay(double amount) {
        System.out.println("Paying ₹" + amount + " using UPI");
    }
}

