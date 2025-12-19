package com.creational.abstractfactory.without.ecommerce.test;

import com.creational.abstractfactory.types.Country;
import com.creational.abstractfactory.types.PaymentMethod;
import com.creational.abstractfactory.without.ecommerce.order.OrderService;

public class Application {

    public static void main(String[] args) {

        OrderService orderService = new OrderService();

        orderService.placeOrder(
                Country.INDIA,
                PaymentMethod.UPI,
                1500
        );

        orderService.placeOrder(
                Country.USA,
                PaymentMethod.PAYPAL,
                200
        );

        orderService.placeOrder(
                Country.EUROPE,
                PaymentMethod.SEPA,
                300
        );
    }
}
