package com.creational.abstractfactory.services.paymentstrategy.india;

import com.creational.abstractfactory.types.PaymentType;
import com.creational.abstractfactory.services.paymentstrategy.PaymentStrategy;

public class UpiPaymentStrategy implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("Paying ₹" + amount + " via UPI");
    }

    @Override
    public PaymentType getSupportedType() {
        return PaymentType.UPI;
    }
}
