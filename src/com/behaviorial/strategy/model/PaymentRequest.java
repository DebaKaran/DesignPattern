package com.behaviorial.strategy.model;

public class PaymentRequest {

    private final long amount;
    private final String currency;
    private final String referenceId;

    public PaymentRequest(long amount, String currency, String referenceId) {
        this.amount = amount;
        this.currency = currency;
        this.referenceId = referenceId;
    }

    public long getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getReferenceId() {
        return referenceId;
    }
}
