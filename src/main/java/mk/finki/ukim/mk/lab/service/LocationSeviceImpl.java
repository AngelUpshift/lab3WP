package mk.finki.ukim.mk.lab.service;

import jakarta.persistence.EntityNotFoundException;
import mk.finki.ukim.mk.lab.model.Location;
import mk.finki.ukim.mk.lab.repository.jpa.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationSeviceImpl implements LocationService{
    private final LocationRepository locationRepository;

    public LocationSeviceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }
    @Override
    public List<Location> findAll() {
        return this.locationRepository.findAll();
    }

    @Override
    public Location findById(long locationId) {
        Location location = locationRepository.findById(locationId)
                .orElseThrow(() -> new EntityNotFoundException("Location not found with id: " + locationId));
        System.out.println("Found location: " + location.name);
        return location;
    }
}
