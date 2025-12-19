package com.creational.abstractfactory.services.paymentstrategy;

import com.creational.abstractfactory.types.PaymentType;

public interface PaymentStrategy {
    void pay(double amount);
    PaymentType getSupportedType();
}
