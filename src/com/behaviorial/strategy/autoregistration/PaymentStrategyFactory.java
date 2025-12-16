package com.behaviorial.strategy.autoregistration;


import com.behaviorial.strategy.types.PaymentType;

import java.util.HashMap;
import java.util.Map;

public class PaymentStrategyFactory {

    private static final Map<PaymentType, PaymentStrategy> REGISTRY = new HashMap<>();

    private PaymentStrategyFactory() {
        // prevent instantiation
    }

    public static void register(PaymentType key, PaymentStrategy strategy) {
        REGISTRY.put(key, strategy);
    }

    public static PaymentStrategy getPaymentStrategy(final PaymentType key) {
        PaymentStrategy paymentStrategy = REGISTRY.get(key);

        if(paymentStrategy == null) {
            throw new IllegalArgumentException("No payment strategy found for key: "+key);
        }

        return paymentStrategy;
    }
}
