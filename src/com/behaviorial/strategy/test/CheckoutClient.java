package com.behaviorial.strategy.test;

import com.behaviorial.strategy.Order;
import com.behaviorial.strategy.impl.PaymentStrategy;
import com.behaviorial.strategy.impl.UPIPaymentStrategy;

public class CheckoutClient {
    public static void main(String[] args) {
        // Create an order
        Order order = new Order(
                "ORD-101",
                50_000,   // ₹500.00
                "INR"
        );

        // Choose strategy explicitly (runtime decision)
        PaymentStrategy paymentStrategy = new UPIPaymentStrategy();
        // PaymentStrategy paymentStrategy = new CreditCardPaymentStrategy();

        // Process payment
        order.processPayment(paymentStrategy);

        // Observe result
        System.out.println("Order ID       : " + order.getOrderId());
        System.out.println("Payment Status : " + order.getPaymentStatus());
        System.out.println("Transaction ID : " + order.getTransactionId());
    }
}
