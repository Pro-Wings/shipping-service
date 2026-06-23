package com.prowings.shipping.model;

/**
 * Simple shipment record used by the shipping-service dummy microservice.
 */
public record Shipment(
    String trackingNumber,
    String orderId,
    String carrier,
    String deliveryStatus
) {
}

