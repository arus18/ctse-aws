package com.orderprocessing.service.order_tracking;

import java.util.List;

public interface LocationService {
    Location addLocation(double latitude, double longitude);
    Location updateLocation(Long id, double latitude, double longitude);
    Location getLocationById(Long id);
    List<Location> getAllLocations();
    void deleteLocation(Long id);
}

