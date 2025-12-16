package com.behaviorial.strategy.spi.autoregistration;


import com.behaviorial.strategy.types.PaymentType;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

public class PaymentStrategyFactory {

    /**private static final Map<PaymentType, PaymentStrategy> REGISTRY = new HashMap<>();

    static {
        loadStrategies();
    }

    private static void loadStrategies() {
        ServiceLoader<PaymentStrategy> loader =
                ServiceLoader.load(PaymentStrategy.class);

        for (PaymentStrategy strategy : loader) {
            REGISTRY.put(strategy.getSupportedPaymentType(), strategy);
        }
    } */


    // Exposed registry is immutable and safe for concurrent reads
    private static final Map<PaymentType, PaymentStrategy> REGISTRY;

    static {
        REGISTRY = loadStrategies();
    }

    private static Map<PaymentType, PaymentStrategy> loadStrategies() {
        Map<PaymentType, PaymentStrategy> tempRegistry = new HashMap<>();

        ServiceLoader<PaymentStrategy> loader =
                ServiceLoader.load(PaymentStrategy.class);

        for (PaymentStrategy strategy : loader) {
            PaymentType key = strategy.getSupportedPaymentType();

            // Defensive check: avoid silent overrides
            if (tempRegistry.containsKey(key)) {
                throw new IllegalStateException(
                        "Duplicate PaymentStrategy found for key: " + key
                );
            }

            tempRegistry.put(key, strategy);
        }

        // Make registry immutable after startup
        return Collections.unmodifiableMap(tempRegistry);
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
