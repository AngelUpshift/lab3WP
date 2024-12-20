//package mk.finki.ukim.mk.lab.repository;
//
//import mk.finki.ukim.mk.lab.model.Location;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public class LocationRepository {
//    public List<Location> locations;
//
//    public LocationRepository() {
//        locations = new ArrayList<>();
//
//        locations.add(new Location("Central Park", "New York, NY", "5000", "A large public park in New York City"));
//        locations.add(new Location("Eiffel Tower", "Paris, France", "300", "A famous landmark in Paris"));
//        locations.add(new Location("Colosseum", "Rome, Italy", "50000", "An ancient amphitheater in Rome"));
//        locations.add(new Location("Pyramids of Giza", "Giza, Egypt", "N/A", "Historic pyramids in Egypt"));
//        locations.add(new Location("Great Wall of China", "Northern China", "N/A", "A famous wall across northern China"));
//    }
//
//    public List<Location> findAll() {
//        return locations;
//    }
//    public Location findById(long locationId) {
//        Optional<Location> newlocation = locations.stream().filter(location -> location.id == locationId).findFirst();
//
//        return newlocation.orElseThrow(() -> new RuntimeException("Location not found!"));
//    }
//}
