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

---
1: Initial Design — Naive Region-Based Implementation

A: Approach

OrderService directly handled:

-> Region checks

-> Payment selection

-> Invoice generation

-> Shipping provider selection

Conditional logic (if / else, switch) was used to assemble components.

B: Problems Identified

B1: OrderService violated Single Responsibility Principle

B2:  Tight coupling to concrete implementations

B: Adding a new region required modifying core business logic

B4: High risk of incompatible combinations (e.g., UPI + VAT)

B5: Difficult to test and extend

This version worked functionally but was fragile and hard to scale.

2: Problem Analysis — Identifying Product Families

During analysis, it became clear that:

A: Payment, Invoice, and Shipping services vary together

B: These components form a region-specific family

C: The client (OrderService) should not assemble these families manually

This insight motivated the move toward Abstract Factory.

3: Introducing Abstract Factory — Region as a Variant

A: Key Design Change

-> Introduced RegionOrderFactory as an abstraction

-> Each region is represented by a concrete factory:

IndiaOrderFactory

USAOrderFactory

EuropeOrderFactory

-> Each factory is responsible for creating a compatible set of:

PaymentService

InvoiceService

ShippingService

-> Result

Region-specific creation logic is fully encapsulated

OrderService no longer depends on concrete implementations

Adding a new region requires adding a new factory only

4: Handling Runtime Payment Choice — Strategy Pattern

A critical distinction was made between:

A: What payment methods are allowed per region (compile-time concern)

B: Which payment method a user selects at runtime (business logic)

To handle this cleanly:

A: Each region-specific PaymentService internally uses the Strategy pattern

B: Supported payment strategies (UPI, Credit Card, PayPal, SEPA) are registered per region

C: Runtime selection is delegated to the strategy layer

This avoids polluting the factory interface with runtime parameters.

5: Immutability & Safety Improvements

To ensure robustness:

A: Payment strategy registries are built using a mutable EnumMap

B: The registry is exposed as an unmodifiable map after construction

C: Defensive checks prevent duplicate strategy registration

This guarantees:

A: Thread-safe read access

B: Fail-fast behavior for configuration errors

C: Clear ownership of mutable state

6: Final Refactored OrderService

After refactoring:

A: OrderService depends only on RegionOrderFactory

B: It orchestrates the order flow without knowing:

Region details

Vendor implementations

Payment mechanisms

C: The service is now:

Stable

Easy to test

Open for extension, closed for modification

---
State Design Pattern

Order → Payment → Shipment
Requirements (Without State Design Pattern)
1. Overview

This module models a basic order processing workflow involving:

Order creation

Payment processing

Shipment handling

The initial implementation is intentionally designed without using the State Design Pattern, relying instead on enums and conditional logic.
This serves as a baseline design to highlight scalability and maintainability issues that arise as state complexity increases.

2. Core Domain Concepts
2.1 Order

An Order represents a customer purchase and acts as the central entity controlling the lifecycle.

Each order has:

A unique order identifier

A payable amount

A lifecycle status

2.2 Payment

Payment is an action, not a long-lived entity.

Payment can be attempted only for eligible orders

Each payment attempt results in either:

Success

Failure

2.3 Shipment

Shipment represents the fulfillment process after payment.

Shipment is allowed only after successful payment

Delivery may succeed or fail

3. Enumerations Used
3.1 Order Status (OrderType)

Represents the current lifecycle state of the order.

Supported values:

NEW – Order created, payment not done

PAID – Payment completed successfully

SHIPPED – Order dispatched

CANCELLED – Order cancelled

3.2 Payment Result (PaymentResult)

Represents the outcome of a payment attempt.

Supported values:

SUCCESS

FAILURE

3.3 Shipment Status (ShipmentStatus)

Represents the current shipment progress.

Supported values:

SHIPPED

DELIVERY_FAILED

DELIVERED

4. Order Lifecycle Rules
4.1 Valid State Transitions

NEW
 └─(payment success)→ PAID
      └─(shipment created)→ SHIPPED
           └─(delivered)→ DELIVERED

4.2 Payment Rules

Payment can be initiated only when order is in NEW state

On payment success:

    Order transitions to PAID

On payment failure:

    Order remains in NEW

Retry is allowed

4.3 Shipment Rules

Shipment can be initiated only when order is in PAID state

Shipment transitions the order to SHIPPED

After shipment:

    Order may be marked as DELIVERED

    Or marked as DELIVERY_FAILED

4.4 Cancellation Rules

Order can be cancelled only when:

NEW

PAID

Order cannot be cancelled after shipment

Once cancelled:

No further operations are allowed

5. Invalid Operations (Must Be Prevented)

Shipping an order that is not paid

Paying an order that is already paid or cancelled

Cancelling an order after shipment

Marking delivery without shipment

All invalid operations must result in runtime errors.

6. Design Constraints (Intentional)

A single Order class manages:

Payment initiation

Shipment initiation

Cancellation

State is managed using:

Enums

Conditional logic (if / switch)

No polymorphic state objects

No State Design Pattern

This design is deliberately simple to expose limitations as requirements grow.

7. Known Limitations

Business rules are scattered across multiple methods

Adding a new state requires modifying existing logic

Order class grows in complexity as transitions increase

Violates Open–Closed Principle (OCP)

These limitations motivate refactoring to the State Design Pattern in the next iteration.