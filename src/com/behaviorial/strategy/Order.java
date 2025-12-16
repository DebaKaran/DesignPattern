package com.behaviorial.strategy;

import com.behaviorial.strategy.impl.PaymentStrategy;
import com.behaviorial.strategy.model.PaymentRequest;
import com.behaviorial.strategy.model.PaymentResult;
import com.behaviorial.strategy.model.PaymentStatus;

public class Order {

    private final String orderId;
    private final long amountInPaise;
    private final String currency;

    private PaymentStatus paymentStatus;
    private String transactionId;

    public Order(String orderId, long amountInPaise, String currency) {
        this.orderId = orderId;
        this.amountInPaise = amountInPaise;
        this.currency = currency;
        this.paymentStatus = PaymentStatus.FAILURE; // default
    }

    public void processPayment(PaymentStrategy paymentStrategy) {

        PaymentRequest request = new PaymentRequest(
                amountInPaise,
                currency,
                orderId
        );

        PaymentResult result = paymentStrategy.pay(request);

        if (result.getStatus() == PaymentStatus.SUCCESS) {
            this.paymentStatus = PaymentStatus.SUCCESS;
            this.transactionId = result.getTranscationId();
        } else {
            this.paymentStatus = PaymentStatus.FAILURE;
        }
    }

    // ---- Getters ----

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getOrderId() {
        return orderId;
    }
}
