package com.orderprocessing.service.order_tracking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    private LocationRepository locationRepository;

    @Override
    public Location addLocation(double latitude, double longitude) {
        Location location = new Location();
        location.setLatitude(latitude);
        location.setLongitude(longitude);
        return locationRepository.save(location);
    }

    @Override
    public Location updateLocation(Long id, double latitude, double longitude) {
        Location location = locationRepository.findById(id).orElse(null);
        if (location != null) {
            location.setLatitude(latitude);
            location.setLongitude(longitude);
            return locationRepository.save(location);
        }
        return null;
    }

    @Override
    public Location getLocationById(Long id) {
        return locationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    @Override
    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }
}

