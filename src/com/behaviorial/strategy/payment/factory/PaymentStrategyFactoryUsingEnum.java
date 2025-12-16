package com.behaviorial.strategy.payment.factory;

import com.behaviorial.strategy.impl.CreditCardPaymentStrategy;
import com.behaviorial.strategy.impl.PaymentStrategy;
import com.behaviorial.strategy.impl.UPIPaymentStrategy;
import com.behaviorial.strategy.types.PaymentType;

import java.util.HashMap;
import java.util.Map;

public class PaymentStrategyFactoryUsingEnum {

    private static final Map<PaymentType, PaymentStrategy> factory = new HashMap<>();

    static {
        factory.put(PaymentType.CREDIT_CARD, new CreditCardPaymentStrategy());
        factory.put(PaymentType.UPI, new UPIPaymentStrategy());
    }

    public static PaymentStrategy getPaymentStrategy(final PaymentType key) {
        PaymentStrategy paymentStrategy = factory.get(key);

        if(paymentStrategy == null) {
            throw new IllegalArgumentException("No payment strategy found for key: "+key);
        }

        return paymentStrategy;
    }
}
