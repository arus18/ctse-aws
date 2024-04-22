package com.orderprocessing.service.order_tracking;

import com.orderprocessing.service.order.Order;
import com.orderprocessing.service.order.OrderService;
import com.orderprocessing.service.order.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-tracking")
public class OrderTrackingController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private LocationService locationService;

    @GetMapping("/{orderId}/status")
    public ResponseEntity<OrderStatus> getOrderStatus(@PathVariable Long orderId) {
        Order order = orderService.getOrderById(orderId);
        if (order != null) {
            return new ResponseEntity<>(order.getStatus(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/{orderId}/location")
    public ResponseEntity<Location> updateDeliveryLocation(@PathVariable Long orderId, @RequestParam double latitude, @RequestParam double longitude) {
        Location location = locationService.addLocation(latitude, longitude);
        return new ResponseEntity<>(location, HttpStatus.OK);
    }

    @GetMapping("/{orderId}/route")
    public ResponseEntity<String> getDeliveryRoute(@PathVariable Long orderId) {
        // Calculate delivery route logic here
        return new ResponseEntity<>("Delivery route retrieved", HttpStatus.OK);
    }

    @GetMapping("/locations/{locationId}")
    public ResponseEntity<Location> getLocationById(@PathVariable Long locationId) {
        Location location = locationService.getLocationById(locationId);
        if (location != null) {
            return new ResponseEntity<>(location, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/locations")
    public ResponseEntity<List<Location>> getAllLocations() {
        List<Location> locations = locationService.getAllLocations();
        return new ResponseEntity<>(locations, HttpStatus.OK);
    }

    @DeleteMapping("/locations/{locationId}")
    public ResponseEntity<Void> deleteLocation(@PathVariable Long locationId) {
        locationService.deleteLocation(locationId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

