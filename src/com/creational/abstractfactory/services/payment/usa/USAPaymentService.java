package com.creational.abstractfactory.services.payment.usa;

import com.creational.abstractfactory.services.payment.PaymentService;
import com.creational.abstractfactory.services.paymentstrategy.PaymentStrategy;
import com.creational.abstractfactory.services.paymentstrategy.india.CreditCardPaymentStrategy;
import com.creational.abstractfactory.services.paymentstrategy.india.UpiPaymentStrategy;
import com.creational.abstractfactory.services.paymentstrategy.usa.CreditCardPaymentStrategyUSA;
import com.creational.abstractfactory.services.paymentstrategy.usa.PaypalPaymentStrategy;
import com.creational.abstractfactory.types.PaymentType;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class USAPaymentService implements PaymentService {

    private final Map<PaymentType, PaymentStrategy> strategies;

    public USAPaymentService() {
        Map<PaymentType, PaymentStrategy> mutableRegistry = new EnumMap<>(PaymentType.class);

        register(new CreditCardPaymentStrategy(), mutableRegistry);
        register(new UpiPaymentStrategy(), mutableRegistry);

        this.strategies = Collections.unmodifiableMap(mutableRegistry);
    }

    private void register(PaymentStrategy strategy, Map<PaymentType, PaymentStrategy> mutableRegistry) {

        PaymentType supportedType = strategy.getSupportedType();

        if(mutableRegistry.containsKey(supportedType)) {
            throw new IllegalStateException(
                    "Duplicate PaymentStrategy for type: " + supportedType
            );
        }

        mutableRegistry.put(supportedType, strategy);
    }

    @Override
    public void pay(double amount, PaymentType paymentType) {
        PaymentStrategy strategy = strategies.get(paymentType);

        if (strategy == null) {
            throw new IllegalArgumentException(
                    "Payment type not supported in USA: " + paymentType
            );
        }

        strategy.pay(amount);
    }
}
