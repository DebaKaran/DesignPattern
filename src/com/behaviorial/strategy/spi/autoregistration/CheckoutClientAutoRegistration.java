package com.behaviorial.strategy.spi.autoregistration;

import com.behaviorial.strategy.types.PaymentType;

public class CheckoutClientAutoRegistration {
    public static void main(String[] args) throws ClassNotFoundException {

        // Create an order
        Order order = new Order(
                "ORD-101",
                50_000,   // ₹500.00
                "INR"
        );

        // Choose strategy explicitly (runtime decision)
        PaymentStrategy paymentStrategy = PaymentStrategyFactory.getPaymentStrategy(PaymentType.UPI);
        // PaymentStrategy paymentStrategy = new CreditCardPaymentStrategy();

        // Process payment
        order.processPayment(paymentStrategy);

        // Observe result
        System.out.println("Order ID       : " + order.getOrderId());
        System.out.println("Payment Status : " + order.getPaymentStatus());
        System.out.println("Transaction ID : " + order.getTransactionId());
    }
}
