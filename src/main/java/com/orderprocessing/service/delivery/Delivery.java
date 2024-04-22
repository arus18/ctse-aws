package com.orderprocessing.service.delivery;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "deliveries")
@Data
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private Long orderId;
    private String deliveryAddress;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

}

