package com.behaviorial.strategy.impl;

import com.behaviorial.strategy.model.PaymentRequest;
import com.behaviorial.strategy.model.PaymentResult;

public class CreditCardPaymentStrategy implements PaymentStrategy {

    private static final double PROCESSING_FEE_PERCENT = 2.0;

    @Override
    public PaymentResult pay(PaymentRequest request) {

        // 1. Basic validation
        if (request.getAmount() <= 0) {
            return PaymentResult.failure("Invalid payment amount");
        }

        if (!isSupportedCurrency(request.getCurrency())) {
            return PaymentResult.failure("Unsupported currency for credit card");
        }

        // 2. Apply credit card processing fee
        long finalAmount = applyProcessingFee(request.getAmount());

        // 3. Simulate card limit check
        if (!hasSufficientLimit(finalAmount)) {
            return PaymentResult.failure("Insufficient credit limit");
        }

        // 4. Simulate gateway call
        boolean gatewayResponse = simulateCardGateway(finalAmount);

        if (gatewayResponse) {
            String transactionId = generateTransactionId();
            return PaymentResult.success(transactionId);
        }

        return PaymentResult.failure("Credit card payment failed at gateway");
    }

    // -------- Internal helper methods --------

    private boolean isSupportedCurrency(String currency) {
        return "INR".equalsIgnoreCase(currency) || "USD".equalsIgnoreCase(currency);
    }

    private long applyProcessingFee(long amountInPaise) {
        return amountInPaise + Math.round(amountInPaise * PROCESSING_FEE_PERCENT / 100);
    }

    private boolean hasSufficientLimit(long amountInPaise) {
        // Example rule: credit limit = ₹2,00,000
        return amountInPaise <= 20_00_000;
    }

    private boolean simulateCardGateway(long amountInPaise) {
        // Randomized success simulation
        return amountInPaise % 2 == 0;
    }

    private String generateTransactionId() {
        return "CC-" + System.currentTimeMillis();
    }
}

