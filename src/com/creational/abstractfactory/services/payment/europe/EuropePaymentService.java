package com.creational.abstractfactory.services.payment.europe;

import com.creational.abstractfactory.services.payment.AbstractPaymentService;
import com.creational.abstractfactory.services.paymentstrategy.PaymentStrategy;
import com.creational.abstractfactory.services.paymentstrategy.india.CreditCardPaymentStrategy;
import com.creational.abstractfactory.services.paymentstrategy.india.UpiPaymentStrategy;
import com.creational.abstractfactory.types.PaymentType;

import java.util.Map;

public class EuropePaymentService extends AbstractPaymentService {

    @Override
    protected void registerStrategies(Map<PaymentType, PaymentStrategy> registry) {
        register(new CreditCardPaymentStrategy(), registry);
        register(new UpiPaymentStrategy(), registry);
    }
}
