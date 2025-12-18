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

---
Background - Factory Design Pattern

We are building a Report Generation System for an application that needs to generate reports in different formats for users.

### Functional Requirements

1: The system must support generating reports in multiple formats.

2: Initially, the following report formats are required:

A: PDF

B: Excel

C: CSV

3: The client should be able to request a report by specifying the report type.

4: The client should not be concerned with:

A: How the report object is created

B: Which concrete class generates the report

5: Each report type may have its own internal generation logic.

### Non-Functional Requirements

1: The design should allow easy addition of new report formats in the future.

2: Existing client code should not require modification when a new report type is added.

3: The design should keep object creation logic separate from business logic.

### Goal

Design the system such that:

1: Report generation is decoupled from report creation

2: The system remains extensible and maintainable as report types grow


