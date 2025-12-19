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

---
Naive → Factory → Registry → Immutable → EnumMap → SPI auto-registration

1: Naive Implementation (Baseline)

Approach

Client directly creates report objects using a switch on ReportType.

Characteristics

Client knows all concrete implementations.

Adding a new report type requires modifying client code.

Violates Open–Closed Principle.

Purpose

Establish a working baseline.

Make the object-creation problem visible.

2: Simple Factory Extraction

Approach

Moved report creation logic into a dedicated ReportFactory.

Benefits

Client no longer depends on concrete report classes.

Centralized object creation responsibility.

Limitation

Factory still requires modification for every new report type.

switch logic remains.

3: Registry-Based Factory (Map-backed)

Approach

Replaced switch with a map-based registry.

Mapped ReportType → Report implementation.

Benefits

Cleaner code.

Easier to extend than switch-based logic.

Design Decision

Registry initialized once and used only for lookups.

4: Immutability & Thread Safety

Approach

Registry made immutable after startup.

Used EnumMap wrapped with Collections.unmodifiableMap.

Rationale

Registry is read-only after initialization.

Immutability provides thread safety by design.

EnumMap clearly expresses enum-key intent and improves efficiency.

5: SPI-Based Auto-Registration (Final Design)

Approach

Introduced Java SPI (ServiceLoader) for auto-discovery of Report implementations.

Each report declares its supported ReportType.

Factory dynamically builds registry at startup.

Key Advantages

Factory code does not change when new report types are added.

Fully compliant with Open–Closed Principle.

Enables plugin-style extensibility.

Result

New reports can be added by:

Implementing Report

Registering via META-INF/services

No client or factory modification required.

---

### Design Without Abstract Factory

This module demonstrates an initial, naive implementation of an e-commerce order processing system without using the Abstract Factory pattern.

A: The purpose of this version is educational:

B: To show how a real system is commonly designed at first

C: To clearly expose the design problems

D: To act as a baseline before introducing Abstract Factory

### Business Requirement

The platform supports multiple regions:

A: India

B: USA

C: Europe

For every order, the system must:

A: Process payment

B: Generate invoice

C: Arrange shipping

While the business flow is identical, the implementations vary by region due to:

A: Different payment gateways

B: Different tax regulations

C: Different logistics providers

### Current Design Approach

OrderService directly:

A: Determines the region

B: Selects payment implementation

C: Selects invoice implementation

D: Selects shipping implementation

Region-specific logic is handled using conditional statements (if / else).

All object creation and orchestration happen inside the core service.

### Problems With This Design

1: Violation of Single Responsibility Principle

OrderService is responsible for:

A: Business flow

B: Payment selection

C: Tax rules

D: Shipping vendor selection

This makes the class large, fragile, and hard to reason about.

2: Tight Coupling to Concrete Implementations

OrderService directly depends on:

A: Payment implementations

B: Invoice implementations

C: Shipping implementations

Any change in vendors or regulations forces a change in core business logic.

3: Poor Scalability

Adding a new region (e.g., Japan) requires:

A: Modifying OrderService

B: Adding more conditional logic

C: Retesting all existing regions

This violates the Open/Closed Principle.

4: Risk of Incompatible Object Combinations

Because object selection is manual:

A: Incorrect combinations can be introduced

Example: UPI payment with VAT invoice

B: Such bugs are hard to detect at compile time

C: Often discovered only in production

5: Difficult Testing

Testing OrderService requires mocking:

A: Payment logic

B: Invoice logic

C: Shipping logic

D: Region-based conditions

This increases test complexity and maintenance cost.