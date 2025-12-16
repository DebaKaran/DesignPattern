package com.behaviorial.strategy.payment.factory;

import com.behaviorial.strategy.impl.CreditCardPaymentStrategy;
import com.behaviorial.strategy.impl.PaymentStrategy;
import com.behaviorial.strategy.impl.UPIPaymentStrategy;

import java.util.HashMap;
import java.util.Map;

public class PaymentStrategyFactory {

    private static final Map<String, PaymentStrategy> factory = new HashMap<>();

    static {
        factory.put("CC", new CreditCardPaymentStrategy());
        factory.put("UPI", new UPIPaymentStrategy());
    }

    public static PaymentStrategy getPaymentStrategy(final String key) {
        PaymentStrategy paymentStrategy = factory.get(key);

        if(paymentStrategy == null) {
            throw new IllegalArgumentException("No payment strategy found for key: "+key);
        }

        return paymentStrategy;
    }
}
