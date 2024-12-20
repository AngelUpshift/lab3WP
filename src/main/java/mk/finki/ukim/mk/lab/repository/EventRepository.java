//package mk.finki.ukim.mk.lab.repository;
//
//
//import mk.finki.ukim.mk.lab.model.Event;
//import mk.finki.ukim.mk.lab.model.Location;
//import mk.finki.ukim.mk.lab.model.Review;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public class EventRepository {
//    public List<Event> eventList;
//
//    public EventRepository() {
//        eventList = new ArrayList<>();
//
//        eventList.add(new Event("Event 1", "Description for Event 1", 20, new Location("Central Park", "New York, NY", "5000", "A large public park in New York City"), new Review("", 0)));
//        eventList.add(new Event("Event 2", "Description for Event 2", 30, new Location("Eiffel Tower", "Paris, France", "300", "A famous landmark in Paris"), new Review("", 0)));
//        eventList.add(new Event("Event 3", "Description for Event 3", 10, new Location("Eiffel Tower", "Paris, France", "300", "A famous landmark in Paris"), new Review("", 0)));
//        eventList.add(new Event("Event 4", "Description for Event 4", 5, new Location("Central Park", "New York, NY", "5000", "A large public park in New York City"), new Review("", 0)));
//        eventList.add(new Event("Event 5", "Description for Event 5", 22, new Location("Central Park", "New York, NY", "5000", "A large public park in New York City"), new Review("", 0)));
//        eventList.add(new Event("Event 6", "Description for Event 6", 45, new Location("Central Park", "New York, NY", "5000", "A large public park in New York City"), new Review("", 0)));
//        eventList.add(new Event("Event 7", "Description for Event 7", 66, new Location("Central Park", "New York, NY", "5000", "A large public park in New York City"), new Review("", 0)));
//        eventList.add(new Event("Event 8", "Description for Event 8", 89, new Location("Central Park", "New York, NY", "5000", "A large public park in New York City"), new Review("", 0)));
//        eventList.add(new Event("Event 9", "Description for Event 9", 23, new Location("Central Park", "New York, NY", "5000", "A large public park in New York City"), new Review("", 0)));
//        eventList.add(new Event("Event 10", "Description for Event 10", 10, new Location("Central Park", "New York, NY", "5000", "A large public park in New York City"), new Review("", 0)));
//    }
//    public List<Event> findAll() {
//        return eventList;
//    }
//    public List<Event> searchEvents(String text) {
//        return eventList.stream().filter(event -> event.name.equals(text) || event.description.equals(text)).toList();
//    }
//    public List<Event> searchEventsByRating(int rating) {
//        return eventList.stream().filter(event -> event.popularityScore >= rating).toList();
//    }
//    public List<Event> addEvent (String name, String description, double popularityScore, Location location, Review review) {
//        eventList.add(new Event(name, description, popularityScore, new Location(location.address, location.name, location.capacity, location.description), review));
//        return eventList;
//    }
//    public Event findById(long eventId) {
//        Optional<Event> newlocation = eventList.stream().filter(event -> event.id == eventId).findFirst();
//
//        return newlocation.orElseThrow(() -> new RuntimeException("Location not found!"));
//    }
//    public List<Event> editEvent(long id, String name, String description, double popularityScore, Location location) {
//        Optional<Event> newEvent = eventList.stream().filter(event -> event.id == id).findFirst();
//
//        if(newEvent.isPresent()) {
//            Event event = newEvent.get();
//
//            event.setName(name);
//            event.setDescription(description);
//            event.setPopularityScore(popularityScore);
//            event.setLocation(location);
//        }
//
//        return eventList;
//    }
//
//    public List<Event> deleteEvent(long id) {
//        eventList.removeIf(event -> event.id == id);
//
//        return eventList;
//    }
//
//    public List<Event> reviewEvent(long id, String name, String description, double popularityScore, Location location, Review review) {
//        Optional<Event> newEvent = eventList.stream().filter(event -> event.id == id).findFirst();
//
//        if(newEvent.isPresent()) {
//            Event event = newEvent.get();
//
//            event.setName(name);
//            event.setDescription(description);
//            event.setPopularityScore(popularityScore);
//            event.setLocation(location);
//            event.setReview(review);
//        }
//
//        return eventList;
//    }
//}
