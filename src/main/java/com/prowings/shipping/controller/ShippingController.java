package com.prowings.shipping.controller;

import com.prowings.shipping.model.Shipment;
import com.prowings.shipping.service.ShippingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/api/shipments")
public class ShippingController {
    private static final Logger logger = LoggerFactory.getLogger(ShippingController.class);

    private AtomicInteger counter = new AtomicInteger();


    @Value("${server.port}")
    String serverport;

    private final ShippingService shippingService;

    public ShippingController(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    @GetMapping
    public List<Shipment> getShipments() {
        logger.info("Incoming request: GET /api/shipments");
        List<Shipment> shipments = shippingService.getActiveShipments();
        logger.debug("Returning {} shipments", shipments.size());
        return shipments;
    }

    @GetMapping("/test")
    public String notifyUser() {

        return "Response from Shipping Service : " + serverport;
    }

    @GetMapping("/status")
    public String getShipmentStatus() {

        System.out.println(">>>>>>>>>>sipment called <<<<<<<<<<<");
        if (counter.incrementAndGet() <= 2) {
            throw new RuntimeException(">>>>>>>>>>>  Temporary failure");
        }
        return "Shipment processed successfully";
    }
}


