package com.prowings.shipping.service;

import com.prowings.shipping.model.Shipment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ShippingService {
    private static final Logger logger = LoggerFactory.getLogger(ShippingService.class);

    public List<Shipment> getActiveShipments() {
        logger.info("getActiveShipments: generating dummy shipment data");

        List<Shipment> shipments = Stream.of(
                new Shipment("TN123456789", "ORD-1001", "FedEx", "DISPATCHED"),
                new Shipment("TN987654321", "ORD-1002", "UPS", "IN_TRANSIT"),
                new Shipment("TN555666777", "ORD-1003", "DHL", "DELIVERED")
        ).collect(Collectors.toList());

        logger.debug("Generated {} dummy shipments", shipments.size());
        return shipments;
    }
}

