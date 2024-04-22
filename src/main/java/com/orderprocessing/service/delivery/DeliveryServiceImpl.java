package com.orderprocessing.service.delivery;

import com.orderprocessing.service.delivery.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DeliveryServiceImpl implements DeliveryService {
    @Autowired
    private DeliveryRepository deliveryRepository;

    @Override
    public Delivery createDelivery(Long orderId, String deliveryAddress) {
        Delivery delivery = new Delivery();
        delivery.setOrderId(orderId);
        delivery.setDeliveryAddress(deliveryAddress);
        delivery.setStatus(DeliveryStatus.PENDING);
        return deliveryRepository.save(delivery);
    }

    @Override
    public Delivery updateDeliveryStatus(Long id, DeliveryStatus status) {
        Delivery delivery = deliveryRepository.findById(id).orElse(null);
        if (delivery != null) {
            delivery.setStatus(status);
            return deliveryRepository.save(delivery);
        }
        return null;
    }

    @Override
    public Delivery getDeliveryById(Long id) {
        return deliveryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Delivery> getAllDeliveries() {
        return deliveryRepository.findAll();
    }

    @Override
    public void cancelDelivery(Long id) {
        deliveryRepository.deleteById(id);
    }
}
