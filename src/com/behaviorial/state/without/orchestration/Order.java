package com.behaviorial.state.without.orchestration;

import com.behaviorial.state.without.types.OrderType;
import com.behaviorial.state.without.types.PaymentResult;
import com.behaviorial.state.without.types.ShipmentStatus;

public class Order {

    private final String orderId;
    private final double amount;

    private OrderType orderType;
    private ShipmentStatus shipmentStatus;

    public Order(String orderId, double amount) {
        this.orderId = orderId;
        this.amount = amount;
        this.orderType = OrderType.NEW;
    }

    // ---------------- PAYMENT ----------------

    public void initiatePayment(PaymentResult paymentResult) {

        if (orderType != OrderType.NEW) {
            throw new IllegalStateException(
                    "Payment can be initiated only when order is NEW"
            );
        }

        if (paymentResult == PaymentResult.SUCCESS) {
            this.orderType = OrderType.PAID;
        }
        // FAILURE → stay in NEW (retry allowed)
    }

    // ---------------- SHIPMENT ----------------

    public void initiateShipment() {

        if (orderType != OrderType.PAID) {
            throw new IllegalStateException(
                    "Shipment can be initiated only after payment"
            );
        }

        this.shipmentStatus = ShipmentStatus.SHIPPED;
        this.orderType = OrderType.SHIPPED;
    }

    public void markDelivered() {

        if (shipmentStatus != ShipmentStatus.SHIPPED) {
            throw new IllegalStateException(
                    "Order must be shipped before delivery"
            );
        }

        this.shipmentStatus = ShipmentStatus.DELIVERED;
    }

    public void markDeliveryFailed() {

        if (shipmentStatus != ShipmentStatus.SHIPPED) {
            throw new IllegalStateException(
                    "Delivery failure can occur only after shipment"
            );
        }

        this.shipmentStatus = ShipmentStatus.DELIVERY_FAILED;
    }

    // ---------------- CANCELLATION ----------------

    public void cancelOrder() {

        if (orderType == OrderType.SHIPPED) {
            throw new IllegalStateException(
                    "Cannot cancel order after shipment"
            );
        }

        this.orderType = OrderType.CANCELLED;
    }

    // ---------------- GETTERS ----------------

    public OrderType getOrderType() {
        return orderType;
    }

    public ShipmentStatus getShipmentStatus() {
        return shipmentStatus;
    }

    public String getOrderId() {
        return orderId;
    }

    public double getAmount() {
        return amount;
    }
}
