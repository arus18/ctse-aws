package com.orderprocessing.service.order;

import java.util.List;

public interface OrderService {
    Order createOrder(Order order);
    Order getOrderById(Long id);
    List<Order> getAllOrders();
    Order updateOrderStatus(Long id, OrderStatus status);
    void cancelOrder(Long id);
}

