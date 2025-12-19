package com.creational.abstractfactory.services.paymentstrategy.europe;

import com.creational.abstractfactory.services.paymentstrategy.PaymentStrategy;
import com.creational.abstractfactory.types.PaymentType;

public class CreditCardPaymentStrategyEurope implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("Paying €" + amount + " via CreditCard");
    }

    @Override
    public PaymentType getSupportedType() {
        return PaymentType.CREDIT_CARD;
    }
}