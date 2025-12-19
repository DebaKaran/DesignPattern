package com.creational.abstractfactory.without.ecommerce.test;

import com.creational.abstractfactory.types.Country;
import com.creational.abstractfactory.types.PaymentType;
import com.creational.abstractfactory.without.ecommerce.order.OrderService;

public class Application {

    public static void main(String[] args) {

        OrderService orderService = new OrderService();

        orderService.placeOrder(
                Country.INDIA,
                PaymentType.UPI,
                1500
        );

        orderService.placeOrder(
                Country.USA,
                PaymentType.PAYPAL,
                200
        );

        orderService.placeOrder(
                Country.EUROPE,
                PaymentType.SEPA,
                300
        );
    }
}
