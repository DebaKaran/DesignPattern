package com.behaviorial.strategy.spi.autoregistration;

import com.behaviorial.strategy.model.PaymentRequest;
import com.behaviorial.strategy.model.PaymentResult;
import com.behaviorial.strategy.types.PaymentType;

public class UPIPaymentStrategy implements PaymentStrategy {

    @Override
    public PaymentResult pay(PaymentRequest request) {

        // 1. Basic validation (strategy-specific)
       if(request.getAmount() <= 0) {
           return PaymentResult.failure("Invalid payment amount");
       }

        if (!"INR".equalsIgnoreCase(request.getCurrency())) {
            return PaymentResult.failure("UPI supports only INR");
        }

        // 2. Simulate UPI gateway interaction
        boolean gatewayResponse = simulateUPIGateway(request);

        // 3. Build result based on gateway response
        if (gatewayResponse) {
            String transactionId = generateTransactionId();
            return PaymentResult.success(transactionId);
        }

        return PaymentResult.failure("UPI payment failed at gateway");
    }

    @Override
    public PaymentType getSupportedPaymentType() {
        return PaymentType.UPI;
    }

    // ---- Private helper methods (internal algorithm details) ----

    private boolean simulateUPIGateway(PaymentRequest request) {
        // Example rule: payments above ₹1,00,000 fail
        return request.getAmount() <= 10_00_00;
    }

    private String generateTransactionId() {
        return "UPI-" + System.currentTimeMillis();
    }
}
