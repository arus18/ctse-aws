package com.orderprocessing.service.delivery;

import java.util.List;

public interface DeliveryService {
    Delivery createDelivery(Long orderId, String deliveryAddress);
    Delivery updateDeliveryStatus(Long id, DeliveryStatus status);
    Delivery getDeliveryById(Long id);
    List<Delivery> getAllDeliveries();
    void cancelDelivery(Long id);
}

