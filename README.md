# Payment Processing System – Strategy Pattern

This repository demonstrates a **real-world implementation of the Strategy Design Pattern**
using a payment processing use case.

The design focuses on **clean boundaries**, **runtime flexibility**, and **interview-grade
low-level design principles**.

---

## Problem Statement

Design a payment processing module for an e-commerce system that:

- Supports multiple payment methods (UPI, Credit Card)
- Allows switching payment methods at runtime
- Avoids conditional logic (`if/else`, `switch`) in business flows
- Is open for extension but closed for modification
- Encapsulates payment algorithms cleanly

---

## Core Requirements

Each payment method must:

- Validate payment-specific rules
- Execute its own payment algorithm
- Return a clear payment outcome (success/failure)

The **Order** flow must:
- Remain agnostic to payment implementation details
- React only to the payment result

---

## Rejected Designs (Intentional)

The following designs were intentionally avoided:

```java
boolean validate(Payment payment);
void pay(Payment payment);
boolean isPaymentSuccess(long paymentId);
