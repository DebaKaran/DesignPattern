package com.creational.abstractfactory.services.paymentstrategy.usa;

import com.creational.abstractfactory.types.PaymentType;
import com.creational.abstractfactory.services.paymentstrategy.PaymentStrategy;

public class CreditCardPaymentStrategyUSA  implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("Paying $" + amount + " via CreditCard");
    }

    @Override
    public PaymentType getSupportedType() {
        return PaymentType.CREDIT_CARD;
    }
}