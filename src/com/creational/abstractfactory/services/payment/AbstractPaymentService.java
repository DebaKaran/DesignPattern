package com.creational.abstractfactory.services.payment;

import com.creational.abstractfactory.services.paymentstrategy.PaymentStrategy;
import com.creational.abstractfactory.types.PaymentType;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public abstract class AbstractPaymentService implements PaymentService {

    private final Map<PaymentType, PaymentStrategy> strategies;

    protected AbstractPaymentService() {
        Map<PaymentType, PaymentStrategy> mutableRegistry = new EnumMap<>(PaymentType.class);

        registerStrategies(mutableRegistry);

        this.strategies = Collections.unmodifiableMap(mutableRegistry);
    }

    /**
     * Hook method for region-specific strategy registration
     */
    protected abstract void registerStrategies(Map<PaymentType, PaymentStrategy> registry);

    protected final void register(PaymentStrategy strategy, Map<PaymentType, PaymentStrategy> mutableRegistry) {

        PaymentType supportedType = strategy.getSupportedType();

        if(mutableRegistry.containsKey(supportedType)) {
            throw new IllegalStateException(
                    "Duplicate PaymentStrategy for type: " + supportedType
            );
        }

        mutableRegistry.put(supportedType, strategy);
    }

    @Override
    public final void pay(double amount, PaymentType paymentType) {
        PaymentStrategy strategy = strategies.get(paymentType);

        if (strategy == null) {
            throw new IllegalArgumentException(
                    "Payment type not supported in India: " + paymentType
            );
        }

        strategy.pay(amount);
    }
}
