package com.creational.abstractfactory.test;

import com.creational.abstractfactory.order.OrderService;
import com.creational.abstractfactory.region.RegionOrderFactory;
import com.creational.abstractfactory.region.india.IndiaOrderFactory;
import com.creational.abstractfactory.types.PaymentType;

public class Application {
    public static void main(String[] args) {
        // Region selection (config, request, env, etc.)
        RegionOrderFactory factory = new IndiaOrderFactory();

        OrderService orderService = new OrderService(factory);

        orderService.placeOrder(1500, PaymentType.UPI);
        orderService.placeOrder(2000, PaymentType.CREDIT_CARD);
    }
}
