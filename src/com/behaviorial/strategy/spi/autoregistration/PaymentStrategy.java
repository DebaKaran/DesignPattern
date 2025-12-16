package com.behaviorial.strategy.spi.autoregistration;

import com.behaviorial.strategy.model.PaymentRequest;
import com.behaviorial.strategy.model.PaymentResult;
import com.behaviorial.strategy.types.PaymentType;

/**
 *
 */
public interface PaymentStrategy {

    /**
     * The following method split was intentionally rejected:
     *
     *  boolean validate(Payment payment);
     *  boolean isPaymentSuccess(long paymentId);
     *  void pay(Payment payment);
     *
     * Reasons:
     * 1. Exposes the domain entity (Payment) to the strategy, creating tight coupling.
     * 2. Leaks payment workflow control to the client (validate → pay),
     *    which defeats the purpose of Strategy as a self-contained algorithm.
     * 3. `isPaymentSuccess(paymentId)` turns the strategy into a state-querying service,
     *    rather than an algorithm executor.
     * 4. Encourages conditional logic in the client based on payment type,
     *    violating Open/Closed Principle.
     *
     * A payment strategy should execute the complete payment flow internally
     * and return a single outcome object to the caller.
     */



    /*
     * Why not: boolean pay(double amount);
     *
     * 1. `double` is unsafe for monetary calculations due to precision issues.
     * 2. A boolean return value loses important context such as:
     *    - failure reason
     *    - transaction/reference id
     *    - retry eligibility
     * 3. Payment strategies should return a result object, not just success/failure,
     *    to keep the interface extensible without modification.
     */


    //Input Object  →  Algorithm  →  Output Object

    PaymentResult pay(PaymentRequest request);

    PaymentType getSupportedPaymentType();

}
