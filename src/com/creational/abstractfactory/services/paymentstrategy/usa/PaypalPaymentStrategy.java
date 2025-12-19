package com.creational.abstractfactory.services.paymentstrategy.usa;

import com.creational.abstractfactory.services.paymentstrategy.PaymentStrategy;
import com.creational.abstractfactory.types.PaymentType;

public class PaypalPaymentStrategy  implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("Paying $" + amount + " using PayPal");
    }

    @Override
    public PaymentType getSupportedType() {
        return PaymentType.PAYPAL;
    }
}