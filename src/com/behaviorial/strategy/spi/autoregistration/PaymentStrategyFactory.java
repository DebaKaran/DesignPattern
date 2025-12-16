package com.behaviorial.strategy.spi.autoregistration;


import com.behaviorial.strategy.types.PaymentType;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

public class PaymentStrategyFactory {

    private static final Map<PaymentType, PaymentStrategy> REGISTRY = new HashMap<>();

    static {
        loadStrategies();
    }

    private static void loadStrategies() {
        ServiceLoader<PaymentStrategy> loader =
                ServiceLoader.load(PaymentStrategy.class);

        for (PaymentStrategy strategy : loader) {
            REGISTRY.put(strategy.getSupportedPaymentType(), strategy);
        }
    }

    private PaymentStrategyFactory() {
        // prevent instantiation
    }

    public static PaymentStrategy getPaymentStrategy(final PaymentType key) {
        PaymentStrategy paymentStrategy = REGISTRY.get(key);

        if(paymentStrategy == null) {
            throw new IllegalArgumentException("No payment strategy found for key: "+key);
        }

        return paymentStrategy;
    }
}
