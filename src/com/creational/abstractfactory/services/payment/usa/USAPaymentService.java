package com.creational.abstractfactory.services.payment.usa;

import com.creational.abstractfactory.services.payment.AbstractPaymentService;
import com.creational.abstractfactory.services.paymentstrategy.PaymentStrategy;
import com.creational.abstractfactory.services.paymentstrategy.usa.CreditCardPaymentStrategyUSA;
import com.creational.abstractfactory.services.paymentstrategy.usa.PaypalPaymentStrategy;
import com.creational.abstractfactory.types.PaymentType;

import java.util.Map;

public class USAPaymentService extends AbstractPaymentService {

    @Override
    protected void registerStrategies(Map<PaymentType, PaymentStrategy> registry) {
        register(new CreditCardPaymentStrategyUSA(), registry);
        register(new PaypalPaymentStrategy(), registry);
    }
}
