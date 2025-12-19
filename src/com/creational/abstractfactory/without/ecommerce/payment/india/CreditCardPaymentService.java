package com.creational.abstractfactory.payment.india;

import com.creational.abstractfactory.payment.PaymentService;

public class CreditCardPaymentService  implements PaymentService {

    @Override
    public void pay(double amount) {
        System.out.println("Paying ₹" + amount + " using CreditCard");
    }
}

