package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import mk.finki.ukim.mk.lab.model.Review;

import java.util.List;
import java.util.Optional;

public interface EventService{
    List<Event> findAll();
    List<Event> findAllByName(String text);
    List<Event> findEventsByPopularityScore(double rating);
    Optional<Event> save (String name, String description, double popularityScore, Location location);
    Event findById(long eventId);
    Optional<Event> editEvent(long id, String name, String description, double popularityScore, Location location);
    void deleteById(long id);
    Optional<Event> reviewEvent(long id, String name, String description, double popularityScore, Location location);
    List<Event> findAllByLocation_Id(Long locationId);
}
