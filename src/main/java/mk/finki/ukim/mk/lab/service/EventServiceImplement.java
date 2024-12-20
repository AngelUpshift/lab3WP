package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import mk.finki.ukim.mk.lab.model.Review;
import mk.finki.ukim.mk.lab.repository.jpa.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImplement implements EventService{
    private final EventRepository eventRepository;

    public EventServiceImplement(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
    @Override
    public List<Event> findAll() {
        return this.eventRepository.findAll();
    }
    @Override
    public List<Event> findAllByName(String text) {
        return this.eventRepository.findAllByName(text);
    }
    @Override
    public List<Event> findEventsByPopularityScore(double rating) {return  this.eventRepository.findEventsByPopularityScore(rating);}

    @Override
    public Optional<Event> save(String name, String description, double popularityScore, Location location) {
        return Optional.of(this.eventRepository.save(new Event(name, description, popularityScore, location)));
    }

    @Override
    public Event findById(long eventId) {
        return this.eventRepository.findById(eventId);
    }

    @Override
    public Optional<Event> editEvent(long id, String name, String description, double popularityScore, Location location) {
       this.eventRepository.deleteById(id);

       return Optional.of(this.eventRepository.save(new Event(name, description, popularityScore, location)));
    }

    @Override
    public void deleteById(long id) {
        this.eventRepository.deleteById(id);
    }


    public Optional<Event> reviewEvent(long id, String name, String description, double popularityScore, Location location) {
        this.eventRepository.deleteById(id);

        return Optional.of(this.eventRepository.save(new Event(name, description, popularityScore, location)));
    }

    @Override
    public List<Event> findAllByLocation_Id(Long locationId) {
        return this.eventRepository.findAllByLocationId(locationId);
    }
}
