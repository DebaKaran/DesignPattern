package com.creational.abstractfactory.services.payment;

import com.creational.abstractfactory.types.PaymentType;

public interface PaymentService {
    void pay(double amount, PaymentType paymentType);
}
