package com.orderprocessing.service.order_tracking;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "locations")
@Data
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private double latitude;
    private double longitude;


}

