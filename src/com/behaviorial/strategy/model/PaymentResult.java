package com.behaviorial.strategy.model;

import com.behaviorial.strategy.types.PaymentStatus;

public class PaymentResult {

    private final PaymentStatus status;
    private final String transcationId;
    private final String failureReason;

    private PaymentResult(PaymentStatus status, String transcationId, String failureReason) {
        this.status = status;
        this.transcationId = transcationId;
        this.failureReason = failureReason;
    }

    public static PaymentResult success(final String transcationId) {
        return new PaymentResult(PaymentStatus.SUCCESS, transcationId, null);
    }

    public static PaymentResult failure(final String reason) {
        return new PaymentResult(PaymentStatus.SUCCESS, null, reason);
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public String getTranscationId() {
        return transcationId;
    }

    public String getFailureReason() {
        return failureReason;
    }
}
