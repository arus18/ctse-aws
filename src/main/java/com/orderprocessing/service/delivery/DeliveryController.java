package com.orderprocessing.service.delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;

    @PostMapping
    public ResponseEntity<Delivery> createDelivery(@RequestParam Long orderId, @RequestParam String deliveryAddress) {
        Delivery createdDelivery = deliveryService.createDelivery(orderId, deliveryAddress);
        return new ResponseEntity<>(createdDelivery, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Delivery> getDeliveryById(@PathVariable Long id) {
        Delivery delivery = deliveryService.getDeliveryById(id);
        if (delivery != null) {
            return new ResponseEntity<>(delivery, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Delivery>> getAllDeliveries() {
        List<Delivery> deliveries = deliveryService.getAllDeliveries();
        return new ResponseEntity<>(deliveries, HttpStatus.OK);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Delivery> updateDeliveryStatus(@PathVariable Long id, @RequestParam DeliveryStatus status) {
        Delivery updatedDelivery = deliveryService.updateDeliveryStatus(id, status);
        if (updatedDelivery != null) {
            return new ResponseEntity<>(updatedDelivery, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelDelivery(@PathVariable Long id) {
        deliveryService.cancelDelivery(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

